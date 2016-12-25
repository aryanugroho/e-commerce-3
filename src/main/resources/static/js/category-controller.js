/**
 * Created by suat on 12/22/16.
 */
'use-strict'

var CategoryListCtrl = function ($scope, $http, $location, $rootScope) {

    $scope.categorys = {};

    $scope.fetchCategoryList = function () {
        $http.get('/rest/category/list').success(function (result) {
            $scope.categorys = result.categoryList;
        });
    };

    $scope.viewCategory = function (category) {
        $http.get('/rest/category/' + category.link).success(function () {
            $rootScope.categoryLink = category.link;
            $rootScope.categoryName = category.name;
            $location.path("/category/" + category.link);
        }).error(function() {
            alert("Error created category");
        });
    };

    $scope.fetchCategoryList();
};

var CategoryCreateCtrl = function ($scope, $http, $location) {
    $scope.createNewCategory = function (category) {
        $http.post('/rest/category', category).success(function () {
            $location.path("/rest/category/list");
        }).error(function() {
            alert("Error created category");
        });
    };
}

var CategoryViewCtrl = function ($scope, $http, $routeParams) {

    
}