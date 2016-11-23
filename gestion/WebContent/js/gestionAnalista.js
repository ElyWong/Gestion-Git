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
	var id = idAnalista;
	
	$.ajax({
		type : "POST",
		url : "./gestionAnalista", //servlet al q se le hara la peticion
		data : { // clave : valor
			idAnalista: id,
			tipo: 'recuperar'
		},
	
		success : function(respuesta) {
			console.log("Respuesta json:" + respuesta );
			var arregloAnalista = JSON.parse(respuesta); /* FORZOSAMENTE NECESITAMOS PARSEAR A UN OBJETO (CONVERTIR STRING A JSON )*/
			
			$.each(arregloAnalista, function(index, value) { /* ITERAMOS EL ARREGLO DE JSON */
				id = value.id; /* OBTENEMOS EL NOMBRE */
				var nombreAnalista = value.nombre;
				var ap = value.ap;
				var am = value.am;
				var tipo = value.tipo;
			
				document.getElementById("idEditar").value = id;
				document.getElementById("nombreEditar").value = nombreAnalista;
				document.getElementById("apEditar").value = ap;
				document.getElementById("amEditar").value = am;
				document.getElementById("tipoEditar").value = tipo;

			});
		},
		error : function(err) {
			console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
			alert("ERROR: ERROR al eliminar analista");
		}
	});
}

function actualizarAnalista () {
	var response = false;
	var id = document.getElementById("idEditar").value;
	var nombre = document.getElementById("nombreEditar").value;
	var ap = document.getElementById("apEditar").value;
	var am = document.getElementById("amEditar").value;
	var tipoUsuario = document.getElementById("tipoEditar").value;
	
	$.ajax({
		type : "POST",
		url : "./gestionAnalista", //servlet al q se le hara la peticion
		data : { // clave : valor
			idAnalista: id,
			tipo: 'editar',
			nombre : nombre,
			ap : ap,
			am : am,
			tipoUsuario : tipoUsuario
		},
	
		success : function(respuesta) {
			response = respuesta;
			console.log("Respuesta actualizar analista:"+respuesta);
		
			if (response) {
				alert("Analista actualizado correctamente");
				location.reload(true);
			} else {
				alert("Error al actualizar analista");
			}
		
		},
		error : function(err) {
			console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
			alert("ERROR: ERROR al actualizar analista");
		}
	});
}

function esconderModales() {
	$('#myModal').css( "display", "none" );
	$('#modalEdit').css( "display", "none" );
}

function modalAgregar(){
	$('#myModal').css( "display", "block" );
	
	$('#myModal').modal('show');
	
	setTimeout( function(){
		$('#modalEdit').modal('hide');
		$('#modalEdit').css( "display", "none" );
	}, 100);
	
}

function modalEditar(){
	$('#modalEdit').css( "display", "block" );
	
	$('#modalEdit').modal('show');
	
	setTimeout( function(){
		$('#myModal').modal('hide');
		$('#myModal').css( "display", "none" );
	}, 100);
	
}
