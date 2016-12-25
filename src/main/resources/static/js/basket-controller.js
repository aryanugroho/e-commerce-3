/**
 * Created by suat on 12/23/16.
 */
'use strict';

var BasketListCtrl = function ($scope, $rootScope, $http, $location, $timeout ) {

    $scope.baskets = {};
    $scope.products = {};
    
    $scope.fetchBasketList = function () {
        $http.get('/rest/basket/list').success(function (result) {
            $scope.baskets = result;
            $scope.products = result.products;
        });
    };

    $scope.fetchBasketList();

}