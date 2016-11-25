$(function() {
	
	listarAlumnos();
	
	$("#cancelar").click(function(event) {
		propDisabled(true);
		limpiarFormulario();
	});
	
	$("#tableAlumno tr").click(function () {
		var tdArray = $(this).children();
		$("#boleta").val(tdArray[0].innerHTML);
		$("#nombre").val(tdArray[1].innerHTML);
		$("#email").val(tdArray[2].innerHTML);
		$("#estatus").val(tdArray[3].innerHTML);
		$("#nivel").val(tdArray[4].innerHTML);
		propDisabled(false);
	});
	
	$("#agregarAlumno").click(function() {
		AJAX.ejecutar("A");
	});
	
	$("#modificarAlumno").click(function() {
		AJAX.ejecutar("M");
	});

	$("#eliminarAlumno").click(function() {
		AJAX.ejecutar("E");
	});
	
	propDisabled(true);
	
});

var AJAX = function() {
	
	function ejecutar(operacion) {
		
		var boleta = $("#boleta").val();
		var nombre = $("#nombre").val();
		var email = $("#email").val();
		var estatus = $("#estatus").val();
		var nivel = $("#nivel").val();
		
		$.ajax({
			url: "gestionAlumno", 
			method: "POST",
			data: {
				operacion: operacion,
				boleta: boleta, 
				nombre: nombre, 
				email: email,
				estatus: estatus,
				nivel: nivel
			}
		}).done(function(data) {
			alert("" + data);
		});
		window.setTimeout('location.reload()', 1000);
	}
	
	return {
		ejecutar: ejecutar
	};
	
}();

function listarAlumnos() {
	$.ajax({
		url: "gestionAlumno", 
		method: "GET", 
		async: false,
		success: function(data) {
			$("#tableAlumno").html(data);
			cargarTabla();
		}
	});
}

function propDisabled(value) {
	$("#modificarAlumno").prop("disabled", value);
	$("#eliminarAlumno").prop("disabled", value);
}

function limpiarFormulario() {
	$("#boleta").val("");
	$("#nombre").val("");
	$("#email").val("");
	$("#estatus").val("");
	$("#nivel").val("");
}

function cargarTabla() {
	var table = $('#table').DataTable({
        "language": {
          "sProcessing":     "Procesando...",
          "sLengthMenu":     "Mostrar _MENU_ registros",
          "sZeroRecords":    "No se encontraron resultados",
          "sEmptyTable":     "Ningún dato disponible en esta tabla",
          "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
          "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
          "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
          "sInfoPostFix":    "",
          "sSearch":         "Buscar:",
          "sUrl":            "",
          "sInfoThousands":  ",",
          "sLoadingRecords": "Cargando...",
          "oPaginate": {
            "sFirst":    "Primero",
            "sLast":     "Último",
            "sNext":     "Siguiente",
            "sPrevious": "Anterior"
          },
          "oAria": {
            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
          }
        }
    });
}