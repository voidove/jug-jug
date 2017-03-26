var angular = require('angular');

var addressBookDir = angular.module('addressBookDir', []);
addressBookDir.directive('addressBook', function () {
  require('./address-book.scss');
  return {
    restrict: 'E',
    templateUrl: './addressbook/directives/address-book.html'
  }
});

