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
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-navbar-collapse">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
		<a class="navbar-brand" href="#">App Course</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-navbar-collapse">
	    <ul class="nav navbar-nav">  
	      <li>{{#linkTo 'courses'}}Course Catalogue{{/linkTo}}</li>
	      <li>{{#linkTo 'about'}}About{{/linkTo}}</li>
	    </ul>
  	</div>
</nav>
{{outlet}}  
</script>

<!-- Including template for 'about' section -->
<jsp:include page="about.jsp"/>

<!-- Including 'course catalog' section -->
<jsp:include page="list-courses.jsp" />

<!-- Including 'add course' section -->
<jsp:include page="add-course.jsp" />

<script src="js/lib/jquery-1.10.2.js"></script>
<script src="js/lib/handlebars-1.1.2.js"></script>
<script src="js/lib/ember-1.3.1.js"></script>
<script src="js/lib/ember-data.min.js"></script>
<script src="js/lib/bootstrap.min.js"></script>
<script src="js/lib/bootstrap-paginator.js"></script>

<script src="js/application.js"></script>
<script src="js/router.js"></script>
<script src="js/model.js"></script>
<script src="js/view.js"></script>
<script src="js/controller.js"></script>
<script src="js/lib/sorting_table_header.js"></script>

</body>
</html>

