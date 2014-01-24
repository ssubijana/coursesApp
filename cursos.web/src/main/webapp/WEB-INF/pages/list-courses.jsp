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