
document.getElementById("btnCambiarClave").addEventListener("click", (evento) => {

	const claveActual = document.getElementById("txtClaveActual");
	const claveNueva1 = document.getElementById("txtClaveNueva1");
	const claveNueva2 = document.getElementById("txtClaveNueva2");

	if (claveNueva1.value != claveNueva2.value) {
		evento.preventDefault();
		claveActual.value = "";
		claveNueva1.value = "";
		claveNueva2.value = "";
		const divMensajeError = document.querySelector(".mensajeErrorClave");
		if(divMensajeError != null) divMensajeError.innerHTML = "";
		document.getElementById("mensajeErrorClaveNueva").innerHTML = "Las contraseñas no coinciden";
	}
});