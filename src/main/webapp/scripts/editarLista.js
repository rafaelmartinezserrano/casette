let draggedItem = null;
let idLista = document.getElementById("nombreLista").getAttribute('data-id');
let nombreLista = document.getElementById("nombreLista").innerHTML;
const divMensaje = document.getElementById("mensajeLista");

// Función para manejar el dragstart
function handleDragStart(evento) {
	draggedItem = this;
	evento.dataTransfer.effectAllowed = 'move';
	evento.dataTransfer.setData('text/html', this.innerHTML);
	this.style.opacity = '0.4'; // Se aplica el efecto de transparencia
}

// Función para manejar el dragover
function handleDragOver(evento) {
	if (evento.preventDefault) {
		evento.preventDefault(); // Necesario para permitir el drop
	}
	evento.dataTransfer.dropEffect = 'move'; // Se ve la flecha de movimiento
	return false;
}

// Función para manejar el drop
function handleDrop(evento) {
	if (evento.stopPropagation) {
		evento.stopPropagation(); // Evita que el evento se propague
	}
	if (draggedItem !== this) {
		// Intercambia el HTML de los elementos
		draggedItem.innerHTML = this.innerHTML;
		this.innerHTML = evento.dataTransfer.getData('text/html');

		// Interambia los data-id de los elementos
		let temId = draggedItem.getAttribute('data-id');
		draggedItem.setAttribute('data-id', this.getAttribute('data-id'));
		this.setAttribute('data-id', temId);
	}
	return false;
}

function handleDragEnd(evento) {
	// Se reestablece la opacidad
	this.style.opacity = '1';
	// Se eliminan los efectos visuales de arrastre
	let items = document.querySelectorAll("#listaCanciones li");
	items.forEach((item) => {
		item.classList.remove("over");
	});
}

// Añadir listeners a los elementos de la lista
let items = document.querySelectorAll("#listaCanciones li");
items.forEach((item) => {
	item.addEventListener('dragstart', handleDragStart, false);
	item.addEventListener('dragover', handleDragOver, false);
	item.addEventListener('drop', handleDrop, false);
	item.addEventListener('dragend', handleDragEnd, false);
});

// Función para guardar el orden de la lista
function guardarOrden() {
	let lista = document.getElementById("listaCanciones");
	let ids = [];
	lista.querySelectorAll('li').forEach((item) => {
		ids.push(item.getAttribute('data-id'));
	});

	let datos = {
		id: idLista,
		nombre: nombreLista,
		orden: ids
	}
	
	// Envia los datos en formato JSON mediante POST
	fetch("EditarLista", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(datos)
	})
	.then(response => {
		if(response.ok) {
			return response.json();
		} else {
			throw new Error("Error en la solicitud", response);
		}
	})
	.then(resultado => {
		switch (resultado.tipo) {
			case "Exito":
				divMensaje.style.color = "green";
				break;
			case "Error":
				divMensaje.style.color = "red";
				break;
		}
		divMensaje.innerHTML = resultado.mensaje;
	});
	
}

function editarNombreLista() {
	let titulo = document.getElementById("nombreLista");
	let inputNombre = document.getElementById("txtNombreLista");
	
	titulo.classList.add("oculto");
	inputNombre.value = titulo.innerHTML;
	inputNombre.classList.remove("oculto");
	inputNombre.addEventListener("change", ()=> {
		nombreLista = inputNombre.value;
		titulo.innerHTML = inputNombre.value;
		titulo.classList.remove("oculto");
		inputNombre.classList.add("oculto");
	});
}

