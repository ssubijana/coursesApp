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


/*App.NewController = Ember.ObjectController.extend({
  needs: ['customers'],
  courseLevels: function() {
    return this.get('controllers.customers');
  }.property(),
});*/