$(function(){
	contenedor = $('#contenedorCategorias');	// Cogemos el elemento html donde colocaremos las categorías de cultivo
	var urlCategoriaCultivo = 'http://localhost:8080/categoriaCultivo/'; // Url de donde se van a conseguir las categorías
	// Operación get para obtener la lista de categorías de cultivo de la aplicación
	$.getJSON(urlCategoriaCultivo,
		function(respuesta){
			contenedor.append($('<h2>').html('Categorías')); // Colocamos de título 'Categorías' en el html
			contenedor.append($('</h2>'));
			contenedor.append($('<ul id="listaCategorias">')); // Creamos la lista no ordenada de categorías
			contenedor.append($('</ul>'));
			lista = $('#listaCategorias'); // Obtenemos el elemento html en la variable lista
			for (categoria in respuesta){ // Categoría obtiene el índice de cada una de las categorías obtenidas en el parámetro respuesta que contiene la lista de cultivos
				elemento = $('<li>').html(respuesta[categoria].nombre); // Creamos un elemento de la lista por cada categoría existente
				lista.append(elemento); // Se coloca al final del html
				lista.append($('</li>'));
				var button = document.createElement('button'); // Creamos el botón para cada categoría
				button.type = 'button'; // Indicamos que es de tipo button
				button.id = respuesta[categoria].nombre;
				button.innerText = 'Mostrar'; // Le ponemos título al botón
				elemento.append(button); // Insertamos el botón en el html
				button.click(desplegarEspecies);
				elemento.addClass(respuesta[categoria].nombre);
			}
		}
	);
	function desplegarEspecies(){
		$(this).innerText = 'Ocultar';
		url = 'http://localhost:8080/categoriaCultivo/' + $(this).id;
		var itemLista = $("li[class = $(this).id]");
		$.getJSON(url,
			function(respuesta){
				itemLista.append($('<h2>').html('Especies')); // Colocamos de título 'Categorías' en el html
				itemLista.append($('</h2>'));
				itemLista.append($('<ul id="listaEspecies">')); // Creamos la lista no ordenada de categorías
				itemLista.append($('</ul>'));
				lista = $('#listaEspecies'); // Obtenemos el elemento html en la variable lista
				for (especie in respuesta){ // Categoría obtiene el índice de cada una de las categorías obtenidas en el parámetro respuesta que contiene la lista de cultivos
					elemento = $('<li>').html(respuesta[especie].nombre); // Creamos un elemento de la lista por cada categoría existente
					lista.append(elemento); // Se coloca al final del html
					lista.append($('</li>'));
					var button = document.createElement('button'); // Creamos el botón para cada categoría
					button.type = 'button'; // Indicamos que es de tipo button
					button.id = respuesta[especie].nombre;
					button.innerText = 'Mostrar'; // Le ponemos título al botón
					//button.click(desplegarPlagas);
					elemento.append(button); // Insertamos el botón en el html
				}
			}
		);		
	}
});