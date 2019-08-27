//criacao de constrollers
appCliente.controller("clienteController", function ($scope, $http){
	//Variaveis
	//$scope.nome = "Joao";
	//$scope.sobreNome = "Da Silva";
	$scope.clientes = [];
	$scope.cliente={}; // o que setar aqui reflete na tela  -> bind com o model

	//Request alimenta a array clientes com o response da api rest
	//$scope.carregarClientes = function (){
	carregarClientes = function (){
		token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+token;
		
		$http({method:'GET', url:'http://localhost:8080/admin/clientes'})
		.then(function(response){
			$scope.clientes = response.data;
			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarClientes = function (){		
		if ($scope.frmCliente.$valid){
			$http({method:'POST', url:'http://localhost:8080/admin/clientes', data:$scope.cliente})
			.then(function(response){
				$scope.clientes.push (response.data);
				console.log(response.data);
				console.log(response.status);
				carregarClientes();
				//CHAMA PARA LIMPAR O CAMPO
				$scope.cancelarAlteracaoCliente()
				$scope.frmCliente.$setPristine(true);
			}, function (response){
				console.log(response.data);
				console.log(response.status);
			});
			
		}else{
			window.alert("Dados Inválidos");
		}

	}
	
	$scope.excluirCliente = function (cliente) {
		$http({method:'DELETE', url:'http://localhost:8080/admin/clientes/'+cliente.id})
		.then(function(response){
			//Buscar posicao do cliente no array
			 
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice (pos,1); 

			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.alterarCliente = function (cli) {
		$scope.cliente = angular.copy(cli);
		
	}
	
	$scope.cancelarAlteracaoCliente = function(){
		$scope.cliente = {};
	}
	
	
	carregarClientes();
	
	
	
});