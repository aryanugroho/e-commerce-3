/**
 * Created by suat on 12/22/16.
 */
'use-strict'

var app = angular.module('app', ['ngRoute', 'ngResource', 'angularjs-dropdown-multiselect', 'ngFileUpload', 'directives']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: '/views/home.html',
            controller: HomeListCtrl
        })
        .when('/category', {
            templateUrl: '/views/category/list.html',
            controller: CategoryListCtrl
        })
        .when('/add-category', {
            templateUrl: '/views/category/edit.html',
            controller: CategoryCreateCtrl
        })
        .when('/category/:link', {
            templateUrl: '/views/category/view.html',
            controller: CategoryViewCtrl
        })
        .when('/add-product', {
            templateUrl: '/views/product/edit.html',
            controller: ProductCreateCtrl
        })
        .when('/add-basket/:id', {
            templateUrl: '/views/product/add-basket.html',
            controller: ProductAddBasketCtrl
        })
        .when('/basket', {
            templateUrl: '/views/basket/list.html',
            controller: BasketListCtrl
        })
        .otherwise(
            {
                redirectTo: '/',
                templateUrl: '/views/home.html',
                controller: HomeListCtrl
            }
        );
});