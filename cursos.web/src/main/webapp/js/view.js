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