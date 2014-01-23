App.Router.map(function() {
  this.resource('about', { path: "/about" });
  this.resource('courses', { path: "/courses" });
});

//Indicates the model which uses courses route
App.CoursesRoute = Ember.Route.extend({
    model: function() {
        //return all elements in model
        return App.Course.findAll();
    }
});
