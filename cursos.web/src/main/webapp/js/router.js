App.Router.map(function() {
  this.resource('about', { path: "/about" });
  this.resource('courses', { path: "/courses" });
  this.resource('new', { path: "/new" });
});

//Indicates the model which uses courses route
App.CoursesRoute = Ember.Route.extend({
    model: function() {
        //return all elements in model
        return App.Course.findAll();
    }
});

App.NewRoute = Ember.Route.extend({
    model: function() {
        return {};
      }
});

//Indicates the model which uses courses route
/*App.CoursesAddRoute = Ember.Route.extend({
    model: function(){
        return this.store.filter('todo', function (todo) {
            return !todo.get('isCompleted');
        });
    }
    renderTemplate: function(controller){
        this.render('todos/index', {controller: controller});
      }
});*/
