'use strict';

angular.module('opcionesLogin')
  .factory('opcionesResourse', function($resourse){
	var factory={
			agregar:$resource('http://localhost:8383/IntegradorVaoi/rest/:nombre/:clave/:email/:rol',{},{
				loginFacebookAdmin:{method: 'GET', params: {nombre: '@nombre', clave: '@clave', email: '@email', rol:'@rol'}}
			})
	}
	return factory;
});