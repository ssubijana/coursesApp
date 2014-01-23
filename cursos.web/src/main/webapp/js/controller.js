App.CoursesController = Ember.ArrayController.extend({    
    currentItem: 0,
    actions : {
    	displayNone: function(){
	    	this.set('sortProperties', ['level']);
	    	this.set('sortAscending', true);
	    },
	    paginateCourses : function(page){
	      var numItems = this.get('content').content.length;
	      //var itemsPerPage = 1;
	      var from = App.config.itemsPerPage*(page-1);
	      var to = from + App.config.itemsPerPage - 1;

	      this.forEach(function(a,index){
	      	if (index >= from && index <= to) {
	      		a.set('isVisible', true);
	      	} else {
	      		a.set('isVisible', false);
	      	}
	      	console.log(a); console.log(index)
	      });
	    }
  }


});


App.NewController = Ember.ObjectController.extend({
  	selectedLevel : null,
  	selectedTeacher : null,
	courseLevels: [
	{
	  id: 1,
	  description: 'Basic'
	},
	{
	  id: 2,
	  description: 'Intermediate'
	},
	{
	  id: 3,
	  description: 'Advanced'
	}],
	teachers: function() {
        var teacherResp = [];
        $.ajax({
            type : "GET",
            url : "courses/get-teachers",
            success : function(response) {
                response.forEach(function(teacher,index){
                	teacherResp.pushObject(teacher);
                });
            }
        });
        return teacherResp;
    }.property()
});