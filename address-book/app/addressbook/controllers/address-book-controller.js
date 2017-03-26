var angular = require('angular');
require('../../addressbook/models/address-book-model');

var addressBookCtrl = angular.module('addressBookCtrl', ['addressBooks']);
addressBookCtrl
  .controller('addressBookCtrl', function ($scope, addressBooks, $http, $q) {

    $scope.sortType = 'id'; // set the default sort type
    $scope.sortReverse = false;  // set the default sort order
    $scope.newItem = {};
    $scope.isEditing = false; //new item is editing

    //load all address book items
    addressBooks.getAddressBookItems()
      .then(function (result) {
        $scope.addressItems = result.data;
      });

    //update one address book item
    $scope.updateItem = function (addressItem) {
      addressBooks.updateAddressItem(addressItem);
      $scope.isEditing = false;
    };

    //add one address book item
    $scope.addItem = function () {
      $scope.newItem['id'] = $scope.addressItems.length + 1;
      $scope.addressItems.push($scope.newItem);
    };

    //delete one address book item
    $scope.deleteItem = function (addressItem) {
      addressBooks.deleteAddressItem(addressItem);
    };

  });
