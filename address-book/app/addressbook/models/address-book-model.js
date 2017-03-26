var angular = require('angular');
var _ = require('lodash');

var addressBooks = angular.module('addressBooks', []);
addressBooks.service('addressBooks', function AddressBooks($http, $q) {
  var URLS = {
      FETCH: 'addresses.json'
    },
    addressBookItems,
    addressBookModel = this;

  function extract(result) {
    return result.data;
  }

  function cacheAddressBookItems(result) {
    addressBookItems = extract(result);
    return addressBookItems;
  }

  addressBookModel.getAddressBookItems = function () {
    var deferred = $q.defer();
    $http.get(URLS.FETCH).then(function(data) {
      deferred.resolve(data);
    });
    deferred.promise.then(function (result) {
      cacheAddressBookItems(result);
    });
    return deferred.promise
  };

  addressBookModel.createAddressBook = function (addressItem) {
    addressItem.id = addressBookItems.length;
    addressBookItems.push(addressItem);
  };

  addressBookModel.updateAddressItem = function (addressItem) {
    var index = _.findIndex(addressBookItems, function (b) {
      return b.id == addressItem.id
    });
    addressBookItems[index] = addressItem;
  };

  addressBookModel.deleteAddressItem = function (addressItem) {
    _.remove(addressBookItems, function (b) {
      return b.id == addressItem.id;
    });
  };
  })
;