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




app.controller('MyCtrl', function($scope, $http) {
    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: true
    };
    $scope.totalServerItems = 0;
    $scope.pagingOptions = {
        pageSizes: [5, 10, 20],
        pageSize: 5,
        currentPage: 1
    };  
    $scope.setPagingData = function(data, page, pageSize){  
        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        $scope.myData = pagedData;
        $scope.totalServerItems = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };
    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
        setTimeout(function () {
            var data;
            if (searchText) {
                var ft = searchText.toLowerCase();
                $http.get('json/datos.json').success(function (largeLoad) {      
                    data = largeLoad.filter(function(item) {
                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                    });
                    $scope.setPagingData(data,page,pageSize);
                });            
            } else {
                $http.get('json/datos.json').success(function (largeLoad) {
                    $scope.setPagingData(largeLoad,page,pageSize);
                });
            }
        }, 100);
    };
    
    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
    
    $scope.$watch('pagingOptions', function (newVal, oldVal) {
        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    $scope.$watch('filterOptions', function (newVal, oldVal) {
        if (newVal !== oldVal) {
          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    
    $scope.gridOptions = {
        data: 'myData',
        enablePaging: true,
        showFooter: true,
        totalServerItems:'totalServerItems',
        pagingOptions: $scope.pagingOptions,
        filterOptions: $scope.filterOptions
    };
});
