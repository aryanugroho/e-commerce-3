/**
 * Created by suat on 12/23/16.
 */

'use-strict'

var HomeListCtrl = function ($scope, $http) {
    $scope.categorys = {};
    $scope.category2 = {};
    $scope.selectedCategory = '';

    $scope.fetchCategoryList = function () {
        $http.get('/rest/category/list').success(function (result) {
            $scope.categorys = result.categoryList;
        });
    };
    
    $scope.getProduct = function (value) {
        $http.get('/rest/category/list').success(function (result) {
            $scope.categorys2 = result.categoryList;
        });
    };


    $scope.fetchCategoryList();
};