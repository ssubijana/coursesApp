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
<div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="#">Course App</a>
    <ul class="nav">
      <li>{{#linkTo 'courses'}}Course Catalogue{{/linkTo}}</li>
      <li>{{#linkTo 'about'}}About{{/linkTo}}</li>
    </ul>
  </div>
</div>
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
			  	<th>Title</th>
			  	<th>Level</th>
			  	<th>Hours</th>
			</thead>
			{{#each model}}
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
        <div id="paginator"></div>
        
      </div>
    </div>
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

</body>
</html>

