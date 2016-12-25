/**
 * Created by suat on 12/23/16.
 */
'use-strict'

var ProductCreateCtrl = function ($scope, $rootScope, $http, $location, $timeout ) {


    $scope.colors = ["Red", "Black", "Blue", "White", "Green"];
    $scope.sizes = ["XS", "S", "M", "L", "X", "XL"];
    $scope.selectedModel = [];

    $scope.categorys = {};
    $scope.categoryMultiSelectData = [];
    $scope.categoryMultiSelectModel = [];


    $scope.fetchCategoryList = function () {
        $http.get('/rest/category/list').then(function (response) {
            $scope.categorys = response.data.categoryList;
            console.log($scope.categorys);
            if (response.status) {
                $scope.getCategoryListForMultiSelect();
            }
        })
    };

    $scope.getCategoryListForMultiSelect = function () {
        angular.forEach($scope.categorys, function(value, key){
            if( value.name !== undefined && value.name !== null ) {
                $scope.categoryMultiSelectData.push({id : value.name, label : value.name})
            }
        })
    }


    $scope.submitProduct = function(isValid) {

        var categoryObj = [];
        $scope.categoryMultiSelectModel.map(function(selectedCategory) {
            categoryObj.push({name : selectedCategory.id});
        });

        var sentProduct = {
            name: $scope.product.name,
            detail: $scope.product.detail,
            size: $scope.product.size,
            color: $scope.product.color,
            categories: categoryObj
        };

        var file = $scope.productFile;
        /* console.log('file is ' );
         console.dir(file);*/
        var uploadUrl = "/rest/product/add";
        var fd = new FormData();
        fd.append('file', file);
        fd.append('product', angular.toJson(sentProduct, true));
        $http.post(uploadUrl, fd, {
            transformRequest : angular.identity,
            headers : {
                'Content-Type' : undefined
            }
        }).success(function() {
            console.log('success');
            $location.path("/home");
        }).error(function() {
            alert("Error created product");
        });
    };

    $scope.fetchCategoryList();

}

var ProductAddBasketCtrl = function ($scope, $rootScope, $http, $rootScope ) {

    $scope.productDetails = {};
    
    $scope.fetchProductDetail = function () {
        $http.get('/rest/product/' + $rootScope.productId).success(function (result) {
            $scope.productDetails = result;
        });
    };

    $scope.fetchProductDetail();

}