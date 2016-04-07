var tienda = angular.module('tienda', [
  'ngRoute',
  'controladoresTienda'
]);

tienda.config(['$routeProvider',
                    function($routeProvider) {
                      $routeProvider.
                      	when('/inicio', {
                          templateUrl: 'vistas/inicio.html'
                        }).
                        when('/listado/clientes', {
                          templateUrl: 'vistas/listados/listadoClientes.html',
                          controller: 'ControladorListado',
                          tipoListado: 'clientes'
                        }).
                        when('/listado/productos', {
                            templateUrl: 'vistas/listados/listadoProductos.html',
                            controller: 'ControladorListado',
                            tipoListado: 'productos'
                        }).
                        when('/listado/proveedores', {
                            templateUrl: 'vistas/listados/listadoProveedores.html',
                            controller: 'ControladorListado',
                            tipoListado: 'proveedores'
                        }).
                        when('/listado/pedidos', {
                            templateUrl: 'vistas/listados/listadoPedidos.html',
                            controller: 'ControladorListado',
                            tipoListado: 'pedidos'
                        }).
                        when('/nuevo/clientes/', {
                          templateUrl: 'vistas/altas/altaCliente.html',
                          controller: 'ControladorAlta',
                          tipoElemento: 'clientes'
                        }).
                        when('/ver/clientes/:id/', {
                            templateUrl: 'vistas/visualizar/verCliente.html',
                            controller: 'ControladorVer',
                            tipoElemento: 'clientes'
                          }).
                        when('/editar/clientes/:id/', {
                            templateUrl: 'vistas/editar/editarCliente.html',
                            controller: 'ControladorEditar',
                            tipoElemento: 'clientes'
                          }).
                        otherwise({
                          redirectTo: '/inicio'
                        });
                    }]);


