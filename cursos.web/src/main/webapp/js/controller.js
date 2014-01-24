/*** Controller for showing the list of courses ***/
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

/*** Controller for adding a course ***/
App.NewController = Ember.Controller.extend({
	isValidForm : true,
	messageErrors : null,
  	selectedLevel : null,
  	selectedTeacher : null,
  	activeCourse : true,
  	courseTitle : "Insert the title of the course",
  	courseHours : 1,
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
            	if (typeof response !== 'undefined' && response != null && response.success) {
            		response.data.forEach(function(teacher,index){
	                	if (index == 0) {
	                		var controller = App.__container__.lookup("controller:new");
	    					controller.set('selectedTeacher',teacher);
	                	}
	                	teacherResp.pushObject(teacher);
	                });
            	}
            	else if (response !== 'undefined' && response != null && !response.success) {
            		alert(response.messageError);
            	}
               
            },            
		    error:function(data,status,er) { 
		        alert("An error has ocurred and data could not be recovered!");
		    }
        });
        return teacherResp;
    }.property(),
	validateForm : function() {
		var messageErrors = "";
		//Validating title : not null and not empty
		if (this.courseTitle == null || this.courseTitle.length > 25) {
			messageErrors = messageErrors.concat("Title must not be empty\n");
		}
		//Validating hours a numeric value
		if (!$.isNumeric(this.courseHours)) {
			messageErrors = messageErrors.concat("Course hours must have a numeric value\n");
		}
		if (this.selectedTeacher == null || this.selectedTeacher.id == null ) {
			messageErrors = messageErrors.concat("Selected teacher is invalid \n");
		}
		if (this.selectedTeacher == null || this.selectedTeacher.id == null ) {
			messageErrors = messageErrors.concat("Selected teacher is invalid \n");
		}
		if (messageErrors.length > 0) {
			//Some value is invalid
			return ("The course is invalid due to this errors: ").concat(messageErrors);
		}
		return null;
	},	
	addCourse : function() {
  		var courseJSON = {
  			'title': this.courseTitle,
  			'level' : this.selectedLevel.id,
  			'hours' : parseInt(this.get('courseHours'),10),
  			'active' :  this.activeCourse,
  			'id_teacher' : this.selectedTeacher.id
  		};

  		$.ajax({ 
		    url: "courses/add-course", 
		    type: 'POST', 
		    dataType: 'json', 
		    data: JSON.stringify(courseJSON), 
		    contentType: 'application/json',
		    mimeType: 'application/json',
		    success: function(data) { 
		        if (typeof data !== 'undefined' && data != null && data.success) {
		        	var controller = App.__container__.lookup("controller:new");
	    			controller.transitionToRoute('courses');
		        } else if (data !== 'undefined' && data != null && !data.success) {
		        	alert(data.messageError);
		        }

		    },
		    error:function(data,status,er) { 
		        alert("An error has ocurred and the operation could not be completed!");
		    }
		});


	},
    actions: {
    	addCourse : function(content) {
    		var activeCourse = this.activeCourse;
    		var titleCourse = this.courseTitle;
    		var selectedTeacher = this.selectedTeacher.id;
    		var selectedLevel = this.selectedLevel.id;
    		var hoursCourse = parseInt(this.get('courseHours'),10);
    		console.log('adding course: ' + titleCourse);

    		this.messageErrors = this.validateForm();
    		if (this.messageErrors != null && this.messageErrors.length > 0) {
    			this.isValidForm = false;
    			alert(this.messageErrors);
    		}
    		else {
    			this.addCourse();
    			//this.transitionToRoute('courses');
    		}    		
    	}
    }
});