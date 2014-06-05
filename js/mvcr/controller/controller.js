/**
 * Controllers
 */

demo.controller = demo.controller || {};

/**
 * the entry of the project
 */
demo.controller.mainModule = function () {
  return {
    /**
     * Inits all the modules. It will invoke all the init method in the modules
     */
    initModules: function () {
      $.each(demo.controller, function (index, controller) {
        if (controller.init && (typeof controller.init === 'function')) {
          controller.init();
        }
      });
    }
  };
}();