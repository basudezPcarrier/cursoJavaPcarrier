/**
 * 
 */

var AppCatMoviles = angular.module('appCatMoviles' , 
		                           ['ngRoute','controladoresAppMoviles']
) ;


AppCatMoviles.config(['$routeProvider' , function($routeProvider){
	
	/** el when '/' hace que tengamos que poner la / al escribir la dirección y el mismo  
	 *  lo cambia de http://localhost:8080/MVC/ a http://localhost:8080/MVC/#/moviles
	 * 
	 * 
	 * */
	$routeProvider.
		when('/' , {
			templateUrl:'vistas/listado-moviles.html',
			controller: 'ControladorListadoMoviles'
				
		}).
		when('/moviles/:id_movil' , {
			templateUrl:'vistas/detalles-movil.html',
			controller: 'ControladorDetallesMovil'
				
		})

}]);