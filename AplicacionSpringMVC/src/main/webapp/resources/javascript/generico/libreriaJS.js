/**
 * 
 */
(function(window , document) {
	'use strict';
	var inicio = function(){
		var elemento = null,
		 marco = null,
		 rutas = {},
		 controladores = {},
		 controlador = null,
		 libreria = {
				//metodo getId del objeto liberia 
				getID: function (id){
					document.getElementById(id);
					return this;
				},
				//metodo noSubmit del objeto liberia 
				noSubmit: function(){
					elemento.addEventListener('submit', function(e){
						e.preventDefault;
					}, false);
					return this;
				},
				//metodo controlador del objeto liberia 
				controlador: function(nombre , ctrl){
					controlador[nombre] = {'controlador': ctrl};
					return this;
				},
				//metodo enrutar del objeto liberia 
				enrutar: function(){
					marco = elemento;
					return this;
				},
				//metodo rutar del objeto liberia 
				ruta: function(ruta, plantilla, controlador, carga){
					rutas[ruta] = {
							'plantilla':plantilla ,
							'controlador': controlador,
							'carga': carga
					};
					return this;
				},
				manejadorRutas : function(){
					
					var hash = window.location.hash.substring(1) || '/'
					,destino = rutas[hash]
					, xhr = new XMLHttpRequest();
					
					if (destino && destino.plantilla) {
						xhr.addEventListener('load',function(){
						marco.innerHTML = this.responseText;} , false);
						xhr.open('get', destino.plantilla, true);
						xhr.send(null);
					}else {
						window.location.hash = '#/';
					}
				}

		};
		return libreria;
	}
	if (typeof window.libreria === undefined) {
		window.libreria = window._ =inicio();
		window.addEventListener('load', libreria.manejadorRutas,false)
		window.addEventListener('hashchange', libreria.manejadorRutas,false);
	}else{
		console.log('se esta llmando la libreria nuevamente.');
	}
	
})(window , document);