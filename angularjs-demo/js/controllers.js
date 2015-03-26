'use strict';

/* Controllers */

var portalControllers = angular.module('portalControllers', []);

portalControllers.controller('AppListCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('data/app.json').success(function(data) {
      $scope.applist = data;
    });

  }]);

portalControllers.controller('NoticeListCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('data/notice.json').success(function(data) {
      $scope.noticelist = data;
    });

  }]);

portalControllers.controller('NoticeDetailListCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('data/notice.json').success(function(data) {
      $scope.noticelist = data;
      $scope.activeNotice = data[0];
    });

    $scope.setNotice = function(notice) {
      $scope.activeNotice = notice;
    };

  }]);

portalControllers.controller('NoticeDetailCtrl', ['$scope', '$routeParams',
  function($scope, $routeParams) {
    $scope.noticeId = $routeParams.noticeId;
  }]);

