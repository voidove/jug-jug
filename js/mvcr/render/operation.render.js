demo.render = demo.render || {};

demo.render.operation = function() {
  'use strict';
  var $view, el, controller;

  function _mapElements() {
    el = {
      $deleteBtn: $view.find('.js-delete')
    };
  }

  function _bindActions() {
    el.$deleteBtn.on('click', _deleteUser);
  }

  function _deleteUser() {
    controller.deleteUser({id: 1});
  }

  return {
    init: function(_controller) {
      controller = _controller;
      $view = $('.js-user-list');
      _mapElements();
      _bindActions();
    },

    updateUserList: function() {
      alert('Delete user successful!');
    }
  };

}();