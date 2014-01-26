/*** PAGINATOR FUNCTIONS ***/
function paginateCourses(newPage){
    //Launching action paginateCourses of the controller for showing courses of the selected page.
    var controller = App.__container__.lookup("controller:courses");
    controller.send('paginateCourses',newPage);
}

//Creates the paginator taking care of maxnumber of pages and current page to view
function setPaginator(currentPage) {
    var options = {
        currentPage: currentPage,
        totalPages: App.config.maxPages,
        bootstrapMajorVersion: 3,
        onPageChanged: function(e,oldPage,newPage){
            paginateCourses(newPage);
        }
    };
    $('#paginator').bootstrapPaginator(options);
    App.config.currentPage = currentPage;
}

// Registers the function helper for getting the level description by id 
Handlebars.registerHelper('getCourseLevel', function(level) {
  var courseLevel = parseInt(this.get('level'),10);
  switch(courseLevel) {
    case 1:
        return 'Basic';
        break;
    case 2:
        return 'Intermediate';
        break;
    case 3:
        return 'Advanced';
        break;
    default:
        return '';
  }
});