<!-- Template add a course -->
<script type="text/x-handlebars" data-template-name="new">
<h2>Add new course</h2>
<form class="form-horizontal" role="form" {{action addCourse on="submit"}}>
  <div class="form-group">
	 <label for="activeCourse" class="col-sm-2 control-label">Active</label>
    <div class="col-sm-10">
		  <div class="checkbox">
		     {{input id="activeCourse" checked=activeCourse type="checkbox"}}				  	
	  	</div>	
  	</div>
	</div>
	<div class="form-group">
		<label for="teacherSelect" class="col-sm-2 control-label">Teacher</label>
		<div class="col-sm-10">
			{{view Ember.Select
				id = "teacherSelect"
  				content=teachers
   				optionValuePath="content.id"
   				optionLabelPath="content.name"
   				selection=selectedTeacher}}
		</div>
	</div>
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">Title</label>
		<div class="col-sm-10">
			{{input type="text" class="form-control" id="title" value=courseTitle}}
		</div>
	</div>
	<div class="form-group">
		<label for="levelSelect" class="col-sm-2 control-label">Level</label>
		<div class="col-sm-10">
			{{view Ember.Select
				id = "levelSelect"
  				content=courseLevels
   				optionValuePath="content.id"
   				optionLabelPath="content.description"
   				selection=selectedLevel}}
		</div>
	</div>
	<div class="form-group">
		<label for="hours" class="col-sm-2 control-label">Hours</label>
		<div class="col-sm-10">
			{{input id="hours" type="number" min="1" max="120" step="1" value=courseHours}}
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" >Add</button>
		</div>
	</div>
</form>
</script>