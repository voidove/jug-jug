'use strict';

/* App Module */

var portalApp = angular.module('portalApp', [
  'ngRoute',
  'portalControllers'
]);

portalApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'html/home.html',
        controller: ''
      }).
      when('/notice', {
        templateUrl: 'html/notice-detail.html',
        controller: 'NoticeDetailListCtrl'
      }).
      when('/notice/:noticeId', {
        templateUrl: 'html/notice-detail.html',
        controller: ''
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);