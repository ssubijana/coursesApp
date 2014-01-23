App.CoursesController = Ember.ArrayController.extend({
    displayNone: function(){
    	console.log(this.content.length);
    	this.setEach('isVisible', false);
    },
    initialize : function(){
    	console.log(this.get('content'));

    }.observes('content.isLoaded').on('init'),
    currentItem: 0,
    actions : {
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
	      //this.displayNone();
	    }
  }


});