var angular = require('angular');
require('angular-ui-router');

var baseRoute = angular.module('baseRoute', ['ui.router']);
baseRoute.config(function($stateProvider, $locationProvider) {

  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
  });
  var homeState = {
    name: 'home',
    url: '/home',
    templateUrl: './addressbook/main.html'
  }

  var aboutState = {
    name: 'about',
    url: '/about',
    template: '<h3>I am olivia, nice to meet you</h3>'
  }

  $stateProvider.state(homeState);
  $stateProvider.state(aboutState);
});