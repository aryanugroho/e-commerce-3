/**
 * Created by suat on 12/23/16.
 */

'use-strict'

var HomeListCtrl = function ($scope, $http, $location, $rootScope ) {
    $scope.categorys = {};
    $scope.products = [];
    $scope.productDetails = {};
    $scope.selectedCategory = '';

    $scope.fetchCategoryList = function () {
        $http.get('/rest/category/list').success(function (result) {
            $scope.categorys = result.categoryList;
        });
    };
    
    $scope.getProductByCategoryName = function (category) {
        $scope.products.splice(0, $scope.products.length);
        $http.get('/rest/product/list-by-categgory-name/' + category.name).success(function (result) {
            angular.forEach(result, function(value, key){
                if( value.name !== undefined && value.name !== null ) {
                    $scope.products.push(value)
                }
            })
        });
    };

    $scope.getProductDetail = function (product) {
        $rootScope.productId = product.id;
        $location.path("/add-basket/" + product.id);
    };
    
    $scope.fetchCategoryList();
};