var angular = require('angular');
require('./addressbook/controllers/address-book-controller');
require('./addressbook/models/address-book-model');
require('./addressbook/directives/address-book-directive');
require('./base-route');

var myApp = angular.module('addressBookApp', ['addressBookCtrl',
  'addressBookDir', 'addressBooks', 'baseRoute']);