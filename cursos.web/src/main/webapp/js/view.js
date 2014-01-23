App.CoursesView = Ember.View.extend({
    didInsertElement: function() {
        //setPaginator(1);
    }
});

function paginateCourses(newPage){
    //Launching action paginateCourses of the controller for showing courses of the selected page.
    var controller = App.__container__.lookup("controller:courses");
    controller.send('paginateCourses',newPage);
}

//Creates de paginator taking care of maxnumber of pages and current page to view
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
}