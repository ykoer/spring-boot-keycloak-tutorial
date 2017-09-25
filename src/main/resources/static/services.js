angular.module('ProductApp.services', ['ngResource'])

.factory('ProductService', ['$resource', function($resource) {

    return $resource('/product/:id', { id: '@id' }, {
        update: {
          method: 'PUT' // this method issues a PUT request
        }
    });
}])

.factory('SessionService', ['$resource', function($resource) {

     return {
        user: $resource('session/user', {}, {
            get: {
                method: 'GET',
                isArray: false
            }
        })
    }


}]);