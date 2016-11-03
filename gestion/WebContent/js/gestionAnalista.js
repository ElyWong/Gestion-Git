function eliminarAnalista(idAnalista) {
	var confirmacion = confirm("¿Estás seguro de eliminar al analista "+idAnalista+" ?");
	var response = false;
	if (confirmacion) {
		$.ajax({
			type : "POST",
			url : "./gestionAnalista", //servlet al q se le hara la peticion
			data : {
				idAnalista: idAnalista,
				tipo: 'eliminar'		
			},
		
			success : function(respuesta) {
				response = respuesta;
				console.log("Respuesta eliminar analista:"+respuesta);
			
				if (response) {
					alert("Analista eliminado correctamente");
					location.reload(true);
				} else {
					alert("Error al eliminar analista")
				}
			
			},
			error : function(err) {
				console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
				alert("ERROR: ERROR al eliminar analista");
			}
		});
	} 
}

function agregarAnalista(){
	var response = false;
	var id = document.getElementById("idusuario").value;
	var nombre = document.getElementById("nombre").value;
	var ap = document.getElementById("ap").value;
	var am = document.getElementById("am").value;
	var tipoUsuario = document.getElementById("tipo").value;
	var pass = document.getElementById("pass").value;
	
	$.ajax({
		type : "POST",
		url : "./gestionAnalista", //servlet al q se le hara la peticion
		data : { // clave : valor
			idAnalista: id,
			tipo: 'agregar',
			nombre : nombre,
			ap : ap,
			am : am,
			tipoUsuario : tipoUsuario,
			pass : pass
		},
	
		success : function(respuesta) {
			response = respuesta;
			console.log("Respuesta agregar analista:"+respuesta);
		
			if (response) {
				alert("Analista agregado correctamente");
				location.reload(true);
			} else {
				alert("Error al agregar analista");
			}
		
		},
		error : function(err) {
			console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
			alert("ERROR: ERROR al eliminar analista");
		}
	});
	
}

function editarAnalista(idAnalista) {
	
	
}