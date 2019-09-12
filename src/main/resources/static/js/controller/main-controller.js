appCliente.controller("mainController", function($scope, $route, $location, $routeParams, $http, $rootScope){
	
	$scope.$location = $location;
	$scope.$route=$route
	$scope.$routeParams=$routeParams;
	
	$scope.usuario={};
	$scope.usuarioLogado= null;	
	//$scope.token = "";
	
	$scope.autenticar = function (){
		console.log("CHAMOU AUTENTICAR: "); 
		$http.post("http://localhost:8080/autenticar",$scope.usuario).then(function(response){ //http://localhost:8080/autenticar
			console.log("Sucesso - "+response);
			//$scope.token = response.data.token;
			//localStorage.setItem("userToken", response.data.token);
			//$scope.usuarioLogado = response.data.usuario;
			console.log("Usuario: "+response.data.usuario.nome);
			$scope.usuarioLogado = response.data.usuario;
			$rootScope.usuarioLogado = response.data.usuario;
			$location.path('/home')
			/**
			if($scope.usuarioLogado == null){
	            $location.path('/acessoNegado');
	        }*/
		
		},function(response){
			console.log("Falha - "+response);
			$location.path('/acessoNegado');
		});	
		
		//console.log("NOME: "+$scope.usuario.nome + " SENHA:"+$scope.usuario.senha);
		
	}
	
});

/**
//criacao de constrollers
appCliente.controller("loginController", function ($scope, $http){
	
	$scope.usuario={};
	
	//$scope.token = "";
	
	$scope.autenticar = function (){
		//console.log("CHAMOU AUTENTICAR: "); 
		$http.post("/autenticar",$scope.usuario).then(function(response){ //http://localhost:8080/autenticar
			console.log("Sucesso - "+response);
			//$scope.token = response.data.token;
			//localStorage.setItem("userToken", response.data.token);
			
		},function(response){
			console.log("Falha - "+response);
			
		});	
		
		//console.log("NOME: "+$scope.usuario.nome + " SENHA:"+$scope.usuario.senha);
		
	}

	
});
*/