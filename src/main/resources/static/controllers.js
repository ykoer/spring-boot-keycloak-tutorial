angular.module("ProductApp.controllers", ['ProductApp.services'])

    .controller('ProductController', function($scope, $state, SessionService, ProductService) {
       $scope.user = SessionService.user.get();
       $scope.products = ProductService.query();

       $scope.delete = function(product) {
           product.$delete(function() {
               $scope.products.splice($scope.products.indexOf(product),1);
           });
       }
    })

    .controller('ProductDetailsController', function($scope, $state, $stateParams, ProductService) {
       $scope.product = ProductService.get({id: $stateParams.id});

       $scope.submitForm = function(isValid) {
           // check to make sure the form is completely valid
           if (isValid) {
               $scope.product.$update({id:$stateParams.id}, function() {
               });
           }

       };
    })

    .controller('ProductNewController', function($scope, $state, $stateParams, ProductService) {

        $scope.product = {};

        $scope.submitForm = function(isValid) {
           // check to make sure the form is completely valid
           if (isValid) {
               ProductService.save($scope.product, function() {
                   $state.go("products");
               });
           }

       };
    });