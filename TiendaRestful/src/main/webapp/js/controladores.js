var controladoresTienda = angular.module('controladoresTienda', []);

/*
 * Añadimos controladores al módulo AngularJS
 */

/*
 * 		=====================================================
 * 		=													=
 * 		=		ControladorListado							=
 * 		=													=
 * 		=====================================================
 */
controladoresTienda.controller('ControladorListado', 
								['$scope', '$location', '$http', '$route', '$sce', 
								 function ($scope, $location, $http, $route, $sce) {
						
  /*
   * 	$location 	-> Cambios de ruta
   * 	$http 		-> Restful
   * 	$route 		-> Obtener datos de la ruta y actualizar vistas
   * 	$sce		-> Obtener rutas seguras 
   */
									
  $scope.tipoListado = $route.current.$$route.tipoListado;	//Obtenemos parámetro de la ruta
									
  $scope.go = function () {							//Ir a una ruta concatenando los parámetros
	var path = $scope.concatena(arguments);			//Arguments es un parámetro variable
													//  que contiene todos los parámetros
													//  de la función
	
	$location.path($sce.trustAsResourceUrl(path));	//Cambia a otra ruta
  };
  
  $scope.elimina = function (id, url) {				//Elimina un elemento de la lista
		$http({
	          method  : 'DELETE',										//Tipo petición
	          url     : 'servicios/' + $scope.tipoListado + '/' + id	//Servicio Restful
	         })
	          .success(function(data) {
	        	  $route.reload();  //Formazos recarga de vista			//Si va bien, actualizamos
	        	  														//	vista
	          });
	        };
  
  $scope.concatena = function ( arguments) {				//Concatena n parámetros
	  	var cadena = '';
	  	
	    for (var i = 0; i < arguments.length; i++) {
		    cadena = cadena + arguments[i];
		}
		
		return cadena;
	};
 
  
  
  $http.get('servicios/' + $scope.tipoListado).success(function(data) {
	  //Petición GET para obtener los datos del listado
	  $scope.data = data;	//Se guarda lo recibido en la variable de $scope
	  		  
	  });
  
  
  
  $scope.ordenacion = 'id';	//Valor por defecto para ordenar el listado
}]);

/*
 * 		=====================================================
 * 		=													=
 * 		=		ControladorAlta							=
 * 		=													=
 * 		=====================================================
 */
controladoresTienda.controller('ControladorAlta', 
		['$scope', '$location', '$http', '$route', '$sce', '$httpParamSerializerJQLike',
		 function ($scope, $location, $http, $route, $sce, $httpParamSerializerJQLike) {
	
	/*
	 * 	$httpParamSerializerJQLike 	-> Pasa on Object a formato parámetro de formulario
	 */
			
	$scope.tipoElemento = $route.current.$$route.tipoElemento;	//Obtenemos el valor del 
																//  parámetro de la ruta.
																//Qué tipo de elemento
																//  queremos crear
	
	$scope.elemento={};																										
	$scope.send = function () {
		var path = $scope.concatena(arguments);
		$http({
	          method  : 'POST',									//Petición POST
	          url     : path,									//URL servicio Restful
	          data    :  $httpParamSerializerJQLike($scope.elemento), //datos para el servicio
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} //Formato de los datos
	         })
	          .success(function(data) {
	        	  //Si se crea bien, volvemos al listado para ver el cambio
	        	  $location.path($sce.trustAsResourceUrl('listado/' + $scope.tipoElemento));
	          });
	        };
			  
	$scope.concatena = function ( arguments) {
		var cadena = '';
				  	
		for (var i = 0; i < arguments.length; i++) {
			cadena = cadena + arguments[i];
		}
					
		return cadena;
	};
	
}]);

/*
 * 		=====================================================
 * 		=													=
 * 		=		ControladorVer							=
 * 		=													=
 * 		=====================================================
 */
controladoresTienda.controller('ControladorVer', 
		['$scope', '$location', '$http', '$route', '$sce', '$routeParams',
		 function ($scope, $location, $http, $route, $sce, $routeParams) {
	
	/*
	 * 	$routeParams 	-> Permite leer parámetros codificados en la url de la ruta
	 */
			
	$scope.tipoElemento = $route.current.$$route.tipoElemento;
	$scope.id = $routeParams.id;								//Leemos el id de la ruta
	
	$scope.go = function () {
		var path = $scope.concatena(arguments);
		$location.path($sce.trustAsResourceUrl(path));
	};

	$scope.concatena = function ( arguments) {
		var cadena = '';

		for (var i = 0; i < arguments.length; i++) {
			cadena = cadena + arguments[i];
		}

		return cadena;
	};



	switch($scope.tipoElemento){
	case 'clientes':
		//Obtenemos datos del cliente
		$http.get('servicios/' + $scope.tipoElemento + '/' + $scope.id).success(function(data) {
			$scope.cliente = data;
		});
		//Obtenemos datos de los pedidos del cliente
		$http.get('servicios/' + $scope.tipoElemento + '/pedidos/' + $scope.id).success(function(data) {
			$scope.pedidos = data;
		});
		break;
	}



	$scope.ordenacion = 'id';	//Valor por defecto para la ordenación de llistados
}]);

/*
 * 		=====================================================
 * 		=													=
 * 		=		ControladorEditar							=
 * 		=													=
 * 		=====================================================
 */

controladoresTienda.controller('ControladorEditar', 
		['$scope', '$location', '$http', '$route', '$sce', '$routeParams',
		 function ($scope, $location, $http, $route, $sce, $routeParams) {
		
	$scope.tipoElemento = $route.current.$$route.tipoElemento;
	$scope.id = $routeParams.id;
	
	$scope.update = function () {
		var path = $scope.concatena(arguments);
		$http({											//Petición al servicio Restful
	          method  : 'PUT',							//Tipo petición
	          url     : path,							//URL servicio
	          data    :  $scope.cliente					//Pasamos datos
	         })
	          .success(function(data) {
	        	  //Volvemos al listado
	        	  $location.path($sce.trustAsResourceUrl('listado/' + $scope.tipoElemento));
	          });
	};

	$scope.concatena = function ( arguments) {
		var cadena = '';

		for (var i = 0; i < arguments.length; i++) {
			cadena = cadena + arguments[i];
		}

		return cadena;
	};



	switch($scope.tipoElemento){
	case 'clientes':
		//Obtenemos los datos del cliente con el id que nos pasan
		$http.get('servicios/' + $scope.tipoElemento + '/' + $scope.id).success(function(data) {
			$scope.cliente = data;
		});
		break;
	}

}]);
