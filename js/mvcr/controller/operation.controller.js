demo.controller.operation = function() {
  var render, model;

  return {
    init: function() {
      render = demo.render.operation;
      model = demo.model.operation;
      render.init(this);
    },

    deleteUser: function(params) {
      model.deleteUser(params, function(response) {
        render.updateUserList();
      });
    }
  };

}();

