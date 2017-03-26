var angular = require('angular');
require('angular-ui-router');
require('./addressbook/controllers/address-book-controller');
require('./addressbook/models/address-book-model');
require('./addressbook/directives/address-book-directive');

var myApp = angular.module('addressBookApp', ['ui.router', 'addressBookCtrl',
  'addressBookDir', 'addressBooks']);