'use strict';

angular.module('opcionesLoginApp')
  .controller('', function ($scope, LoginResource){
	
	$scope.login=function(){
		LoginResource.agregar.loginFacebookAdmin({nombre: $scope.nombre, clave: '1234', email: $scope.email, rol: '1'});		
	};
});
