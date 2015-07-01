var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('LoginFactory', function ($resource) {
    return $resource('http://localhost:8383/IntegradorVaoi/rest/:nombre/:clave/:email/:rol', {}, {
        update: { method: 'PUT', params: {id: '@id'} } 
    })
});