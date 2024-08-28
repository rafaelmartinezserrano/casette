/**
 * 
 */

function buscarListas(cancion) {
	fetch("BuscarListasUsuario")
	.then(respuesta => respuesta.json())
	.then(datos => verListas(datos, cancion));
}

function verListas(listasReproduccion, cancion) {
	let html = `<a href="javascript:void(0)" class="botonCerrar" onclick="cerrarLista()">X</a>
	<ul>`;
	for (let lista of listasReproduccion) {
		html = html + `<li class="lista" onclick="addCancion(${lista.idLista}, ${cancion});">${lista.nombre}</li>`;
	}
	html = html + `</ul>`;
	let contenedor = document.getElementById("contenedorListas");
	contenedor.innerHTML = html;
	contenedor.style.width = "100%";
	contenedor.style.display = "inline";
}

function addCancion(idLista, idCancion) {
	alert(`Añadiendo cancion ${idCancion} a lista ${idLista}`);
	fetch(`AgregarCancionLista?idCancion=${idCancion}&idLista=${idLista}`)
	.then(document.getElementById("contenedorListas").style.display = "none");
	
}

function cerrarLista() {
    document.getElementById("contenedorListas").style.width = "0";
	document.getElementById("contenedorListas").style.display = "none";
  }




