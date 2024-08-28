/**
 * 
 */

let posicion = 0;

function reproducirLista() {
	let audio = document.getElementById(`cancion-${posicion}`);
	audio.play();
}

function pararOtras(audioActual) {
	let audios = document.querySelectorAll("audio");
	for (let audio of audios) {
		if (audio.id != audioActual.id) {
			audio.pause();
		}
	}
	;
	posicion = audioActual.id.split("-")[1];
}

function ordenAleatorio() {
	let lista = document.getElementById("listaCanciones");
	for (let i = lista.children.length - 1; i > 0; i--) {
        let j = Math.floor(Math.random() * (i + 1));
        let temp = lista.children[i].innerHTML;
        lista.children[i].innerHTML = lista.children[j].innerHTML;
        lista.children[j].innerHTML = temp;
	}
	let audios = document.querySelectorAll("audio");
	pos = 0;
	for (let audio of audios) {
		audio.id = `cancion-${pos}`;
		pos++;
	}
}

function siguienteCancion() {
	posicion++;
	let audio = document.getElementById(`cancion-${posicion}`);
	if (audio != null) {
		audio.play();
	} else {
		let chkBucle = document.getElementById("chkBucle");
		if (chkBucle.checked) {
			posicion = 0;
			audio = document.getElementById(`cancion-${posicion}`);
			audio.play();
		}
	}
	
}