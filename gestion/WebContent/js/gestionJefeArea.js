function eliminarJefeA(idJefeA) {
	var confirmacion = confirm("¿Estás seguro de eliminar al jefe de área "+idJefeA+" ?");
	var response = false;
	if (confirmacion) {
		$.ajax({
			type : "POST",
			url : "./gestionJefeArea", //servlet al q se le hara la peticion
			data : {
				idJefeA: idJefeA,
				tipo: 'eliminar'		
			},
		
			success : function(respuesta) {
				response = respuesta;
				console.log("Respuesta eliminar jefe area:"+respuesta);
			
				if (response) {
					alert("Jefe de área eliminado correctamente");
					location.reload(true);
				} else {
					alert("Error al eliminar al jefe de área")
				}
			
			},
			error : function(err) {
				console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
				alert("ERROR: ERROR al eliminar jefe de área");
			}
		});
	} 
}

function agregarJefeA(){
	var response = false;
	var id = document.getElementById("idusuario").value;
	var nombre = document.getElementById("nombre").value;
	var ap = document.getElementById("ap").value;
	var am = document.getElementById("am").value;
	var tipoUsuario = document.getElementById("tipo").value;
	var pass = document.getElementById("pass").value;
	
	$.ajax({
		type : "POST",
		url : "./gestionJefeArea", //servlet al q se le hara la peticion
		data : { // clave : valor
			idJefeArea: id,
			tipo: 'agregar',
			nombre : nombre,
			ap : ap,
			am : am,
			tipoUsuario : tipoUsuario,
			pass : pass
		},
	
		success : function(respuesta) {
			response = respuesta;
			console.log("Respuesta agregar jefe de área:"+respuesta);
		
			if (response) {
				alert("Jefe de área agregado correctamente");
				location.reload(true);
			} else {
				alert("Error al agregar al jefe de área");
			}
		
		},
		error : function(err) {
			console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
			alert("ERROR: ERROR al eliminar al jefe de área");
		}
	});
	
}

function editarJefeA(idJefeArea) {
	
	
}