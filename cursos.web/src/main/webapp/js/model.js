App.Store = DS.Store.extend({
  revision:12,
  adapter: 'DS.FixtureAdapter' //TODO: Load courses using ajax calling
});

App.Course = DS.Model.extend({
  	title:  DS.attr('string'),
  	level:  DS.attr('string'),
  	hours:  DS.attr('int'),
  	isActive:  DS.attr('boolean'),
  	isVisible:  DS.attr('boolean'),
  	idTeacher:  DS.attr('int')
});

App.Course.FIXTURES = [];


App.Course.findAll =function(){
    var result = Ember.ArrayProxy.create({content: []});
    var content = [];
    var numCourses = 0;
    $.ajax({
    url: 'courses/list',
    dataType: 'json',
    success: function(response){
      if (typeof response !== 'undefined' && response != null && response.success) {
        response.data.forEach(function(course,index){
          var courseEmberObj = App.Course.createRecord(course);
          numCourses++;
          if(index >= App.config.itemsPerPage) {
            content.addObject(courseEmberObj.set('isVisible',false));
          } else {
            content.addObject(courseEmberObj.set('isVisible',true));
          }
          
        }, this);
        App.config.maxPages = Math.ceil(numCourses/App.config.itemsPerPage);//parseInt(numCourses/App.config.itemsPerPage, 10);
        var options = {
            currentPage: 1,
            totalPages: App.config.maxPages,
                onPageChanged: function(e,oldPage,newPage){
                    paginateCourses(newPage);
                }
        }
        setPaginator(1);
        result.set('content', content);
      }
      else if (response !== 'undefined' && response != null && !response.success) {
        alert(response.messageError);
      }
    },            
    error:function(data,status,er) { 
        alert("An error has ocurred and data could not be recovered!");
    }
  });
  return result;
};



