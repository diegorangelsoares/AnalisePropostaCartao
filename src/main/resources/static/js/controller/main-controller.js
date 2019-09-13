appCliente.controller("mainController", function($scope, $route, $location, $routeParams, $http, $rootScope){
	
	$scope.$location = $location;
	$scope.$route=$route
	$scope.$routeParams=$routeParams;
	
	$scope.usuario={};
	$rootScope.usuarioLogado= null;	
	//$scope.token = "";
	
	$scope.mensagem= "";	
	
	$scope.autenticar = function (){
		console.log("CHAMOU AUTENTICAR: "); 
		$http.post("http://localhost:8080/autenticar",$scope.usuario).then(function(response){ //http://localhost:8080/autenticar
			//console.log("Sucesso - "+response);
			//$scope.token = response.data.token;
			//localStorage.setItem("userToken", response.data.token);
			//$scope.usuarioLogado = response.data.usuario;
			console.log("Sucesso com o Usuario: "+response.data.usuario.nome);
			//$scope.usuarioLogado = response.data.usuario;
			$rootScope.usuarioLogado = response.data.usuario;
			$scope.mensagem = "Olá, "+$rootScope.usuarioLogado.nome;
			$scope.usuario = null;
			//$location.path('/home')
			/**
			if($scope.usuarioLogado == null){
	            $location.path('/acessoNegado');
	        }*/
		
		},function(response){
			console.log("Falha - "+response);
			$location.path('/acessoNegado');
			$rootScope.usuarioLogado = null;
			$scope.usuarioLogado = null;
		});	
		
		//console.log("NOME: "+$scope.usuario.nome + " SENHA:"+$scope.usuario.senha);
		
	}
	
	$scope.logout = function (){
		console.log("Chamou o logout. "); 
		$rootScope.usuarioLogado = null;
		$scope.usuario = null;

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