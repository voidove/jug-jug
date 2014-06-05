demo.model = demo.model || {};

demo.model.operation = function() {
  return {
    deleteUser: function(params, callback) {
      $.post('/json/success.json', params, function(response) {
        if (callback && (typeof callback === 'function')) {
          callback(response);
        }
      }, 'JSON');
    }
  };
}();