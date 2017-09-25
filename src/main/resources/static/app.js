angular.module('ProductApp', ['ui.router','ProductApp.controllers'])

    .config(function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/home.html'
            })
            .state('products', {
                url: '/product',
                templateUrl: 'partials/product_list.html',
                controller: 'ProductController'
            })
            .state('product_new', {
                url: '/product',
                templateUrl: 'partials/product_details.html',
                controller: 'ProductNewController'
            })
            .state('product_details', {
                url: '/product/:id',
                templateUrl: 'partials/product_details.html',
                controller: 'ProductDetailsController'
            })
    });




