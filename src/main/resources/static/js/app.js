'use strict';

//Criacao do modulo principal da aplicacao
var appCliente = angular.module("appCliente", ['ngRoute']);

appCliente.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/clientes', {
			templateUrl: 'view/cliente.html',
			controller : "clienteController"
		})
		.when('/clientes/:clienteId', {
			templateUrl: 'view/cliente-detalhe.html',
			controller : "clienteDetalheController"
		})
		.when('/login', {
			templateUrl: 'view/login.html',
			controller : "loginController"
		})
		.otherwise({redirectTo:'/'});	
	
	// configure html5 to get links working on jsfiddle
	//$locationProvider.html5Mode(true);
	
}]);


appCliente.config(function($httpProvider){
		
	$httpProvider.interceptors.push('tokenInterceptor');


	
});

