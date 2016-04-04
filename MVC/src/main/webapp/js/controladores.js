/**
 *  $http.get('json/datos.json'  --> leo ese dato
    		  .success( function( data ){  --> si ha ido bien, ejecutara esta funcion (data es el resultado de leer)
    			$scope.moviles = data ;  
    		  })
              );  
 */

var controladoresAppMoviles = angular.module('controladoresAppMoviles',[]) ;

controladoresAppMoviles.controller ( 'ControladorListadoMoviles'
		                           , [ '$scope' , '$http' , function( $scope , $http) {
		                        	   
		                        	   
     $scope.nombreTienda = 'Mi tienda de moviles' ;
     
     $http.get('json/datos.json')
  		  .success( function( data ){ 
    			$scope.moviles = data ;  
    	}
      );
     
		                           } ]
		                           ) ;

/**
 * el servicio $routeParams va a permitir leer los parametros de la url que recibe
 * 
 * */
controladoresAppMoviles.controller ( 'ControladorDetallesMovil'
        , [ '$scope' , '$routeParams' , function( $scope , $routeParams) {
     	   
	$scope.nombreTienda = 'Mi tienda de moviles -> especifico un  movil' ;
	$scope.idMovil = $routeParams.id_movil ;


        } ]
        ) ;


