<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-15>
<title>Course App Catalogue</title>
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/bootstrap-theme.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

<script type="text/x-handlebars">
<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">App Course</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">  
      <li>{{#linkTo 'courses'}}Course Catalogue{{/linkTo}}</li>
      <li>{{#linkTo 'about'}}About{{/linkTo}}</li>
    </ul>
  </div>
</nav>
{{outlet}}  
</script>

<!-- Template 'about' -->
<script type="text/x-handlebars" data-template-name="about">
	<div class="about">
		<h3>About the app</h3>
		<p>Small application using Emberjs, JQuery, Spring MVC and MyBatis</p>
	</div>
</script>

<!-- Template 'courses' -->
<script type="text/x-handlebars" data-template-name="courses">
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
        	<h2>Course Catalogue</h2>
			<table class="table table-bordered">
			<thead>
			  <tr>
			  	{{view App.SortingTableHeader property="title" text="Title"}}
			  	<th>Level</th>
			  	<th>Hours</th>
			</thead>
			{{#each this}}
			<tr class="course">
				{{#if isVisible}}
				<td>
			  		{{ title }}
				</td>
				<td>{{#getCourseLevel level}}
			  		{{/getCourseLevel}}
				</td>
				<td>
			  		{{ hours }}
				</td>
				{{/if}}
			</tr>
			{{/each}}			
			</table>
        </div>
        <ul id="paginator"></div>
        {{#link-to "new" class="btn btn-default"}}New Course{{/link-to}}    
      </div>
    </div>
</script>

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

<script src="js/lib/jquery-1.10.2.js"></script>
<script src="js/lib/handlebars-1.1.2.js"></script>
<script src="js/lib/ember-1.3.1.js"></script>
<script src="js/lib/ember-data.min.js"></script>
<script src="js/lib/bootstrap.js"></script>
<script src="js/lib/bootstrap-paginator.js"></script>




<script src="js/application.js"></script>
<script src="js/router.js"></script>
<script src="js/model.js"></script>
<script src="js/view.js"></script>
<script src="js/controller.js"></script>
<script src="js/lib/sorting_table_header.js"></script>

</body>
</html>

