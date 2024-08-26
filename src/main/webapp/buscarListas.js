/**
 * 
 */

function buscarListas(cancion) {
	fetch("BuscarListasUsuario")
	.then(respuesta => respuesta.json())
	.then(datos => verListas(datos, cancion));
}

function verListas(listasReproduccion, cancion) {
	let html = `<ul>`;
	for (let lista of listasReproduccion) {
		html = html + `<li class="lista" onclick="addCancion(${lista.idLista}, ${cancion});">${lista.nombre}</li>`;
	}
	html = html + `</ul>`;
	let contenedor = document.getElementById("contenedorListas");
	contenedor.innerHTML = html;
	contenedor.style.display = "block";
}

function addCancion(idLista, idCancion) {
	//alert(`Añadiendo cancion ${idCancion} a lista ${idLista}`);
	fetch(`AgregarCancionLista?idCancion=${idCancion}&idLista=${idLista}`)
	.then(document.getElementById("contenedorListas").style.display = "none");
	
}





