appCliente.controller("mainController", function($scope, $route, $location, $routeParams){
	
	$scope.$location = $location;
	$scope.$route=$route
	$scope.$routeParams=$routeParams;;
	
});