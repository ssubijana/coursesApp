
App.SortingTableHeader = Ember.View.extend({
  tagName: 'th',

  template: Ember.Handlebars.compile('{{view.text}} <span {{bindAttr class="view.icon"}}></span>'),

  classNames: ['pointerCursor'],

  sortableArrayBinding: 'controller', //default the controller //'bindingContext.content',

  paginateCourses: 'controller.paginateCourses',

  icon: function () {
    var sortableArray = this.get('sortableArray');
    if (!Ember.isEmpty(sortableArray)) {
      var sortProps = sortableArray.get('sortProperties');
      if (Ember.isArray(sortProps) && sortProps.contains(this.get('property'))) {
        if (sortableArray.get('sortAscending')) {
          //return 'icon-sort-up';
          return 'glyphicon glyphicon-sort-by-order';
        } else {
          //return 'icon-sort-down';
          return 'glyphicon glyphicon-sort-by-order-alt';
        }
      }
    }
    return 'icon-sort';
  } .property('sortableArray.sortProperties', 'sortableArray.sortAscending'),

  click: function (evt) {
    var sortableArray = this.get('sortableArray');
    var sortProps = sortableArray.get('sortProperties');
    if (Ember.isArray(sortProps) && sortProps.contains(this.get('property'))) {
      sortableArray.toggleProperty('sortAscending');
    }
    sortableArray.set('sortProperties', Ember.makeArray(this.get('property'))); //sortProperties triggers the sort
    this.get("controller").send("paginateCourses",1);
  }
});