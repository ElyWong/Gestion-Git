function eliminarJefeArea(idJefeArea) {
	var confirmacion = confirm("¿Estás seguro de eliminar al analista "+idJefeArea+" ?");
	var response = false;
	if (confirmacion) {
		$.ajax({
			type : "POST",
			url : "./gestionJefeArea", //servlet al q se le hara la peticion
			data : {
				idJefeArea : idJefeArea,
				tipo: 'eliminar'		
			},
		
			success : function(respuesta) {
				response = respuesta;
				console.log("Respuesta eliminar Jefe de area:"+respuesta);
			
				if (response) {
					alert("Jefe de área eliminado correctamente");
					location.reload(true);
				} else {
					alert("Error al eliminar al jefe de área")
				}
			
			},
			error : function(err) {
				console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
				alert("ERROR: ERROR al eliminar al jefe de área");
			}
		});
	} 
}

function agregarJefeArea(){
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
			alert("ERROR: ERROR al agregar al jefe de área");
		}
	});
	
}

function editarJefeArea(idJefeArea) {
	var id = idJefeArea;
	
	$.ajax({
		type : "POST",
		url : "./gestionJefeArea", //servlet al q se le hara la peticion
		data : { // clave : valor
			idJefeArea: id,
			tipo: 'recuperar'
		},
	
		success : function(respuesta) {
			console.log("Respuesta json:" + respuesta );
			var arregloJefeArea = JSON.parse(respuesta); /* FORZOSAMENTE NECESITAMOS PARSEAR A UN OBJETO (CONVERTIR STRING A JSON )*/
			
			$.each(arregloJefeArea, function(index, value) { /* ITERAMOS EL ARREGLO DE JSON */
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
			alert("ERROR: ERROR al editar al jefe de área");
		}
	});
}

function actualizarJefeArea () {
	var response = false;
	var id = document.getElementById("idEditar").value;
	var nombre = document.getElementById("nombreEditar").value;
	var ap = document.getElementById("apEditar").value;
	var am = document.getElementById("amEditar").value;
	var tipoUsuario = document.getElementById("tipoEditar").value;
	
	$.ajax({
		type : "POST",
		url : "./gestionJefeArea", //servlet al q se le hara la peticion
		data : { // clave : valor
			idJefeArea: id,
			tipo: 'editar',
			nombre : nombre,
			ap : ap,
			am : am,
			tipoUsuario : tipoUsuario
		},
	
		success : function(respuesta) {
			response = respuesta;
			console.log("Respuesta actualizar jefe de área:"+respuesta);
		
			if (response) {
				alert("Jefe de área actualizado correctamente");
				location.reload(true);
			} else {
				alert("Error al actualizar al jefe de área");
			}
		
		},
		error : function(err) {
			console.error(err);/* EN CASO DE ERROR REVISAR CONSOLA*/
			alert("ERROR: ERROR al actualizar al jefe de área");
		}
	});
}

function modalAgregar(){
	
	$('#myModal').modal('show');
	$('#myModal').css( "display", "block" );
	
	setTimeout( function(){
		$('#modalEdit').modal('hide');
		$('#modalEdit').css( "display", "none" );
	}, 100);
	
}

function modalEditar(){
	
	$('#modalEdit').modal('show');
	$('#modalEdit').css( "display", "block" );
	
	setTimeout( function(){
		$('#myModal').modal('hide');
		$('#myModal').css( "display", "none" );
	}, 100);
	
}