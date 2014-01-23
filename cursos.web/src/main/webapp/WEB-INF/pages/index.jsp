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
        <button type="button" class="btn btn-default">{{#link-to "new"}}New Course{{/link-to}}</button>    
      </div>
    </div>
</script>

<!-- Template add a course -->
<script type="text/x-handlebars" data-template-name="new">
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="active" class="col-sm-2 control-label">Active</label>
		    <div class="col-sm-10">
				<div class="checkbox">
					<label>
				  		<input type="checkbox" id="active"> 
				  	</label>
			  	</div>	
		  	</div>
	  	</div>
  		<div class="form-group">
    		<label for="title" class="col-sm-2 control-label">Title</label>
    		<div class="col-sm-10">
    			<input type="text" class="form-control" id="title" placeholder="Insert the title of the course">
    		</div>
  		</div>
  		<div class="form-group">
  			<label class="col-sm-2 control-label">Level</label>
  			<div class="col-sm-10">
  				{{view Ember.Select
      				contentBinding="controller.courseLevels"
      				optionValuePath="content.id_level"
      				optionLabelPath="content.description"
      			class="input-medium"}}
  			</div>
  		</div>
  		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
  				<button type="submit" class="btn btn-default">Submit</button>
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

