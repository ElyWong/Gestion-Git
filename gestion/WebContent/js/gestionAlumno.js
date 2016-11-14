$(function() {
	
	listarAlumnos();
	
	$("#cancelar").click(function(event) {
		propDisabled(true);
		limpiarFormulario();
	});
	
	$("tr").click(function () {
		var tdArray = $(this).children();
		$("#boleta").val(tdArray[0].innerHTML);
		$("#nombre").val(tdArray[3].innerHTML);
		$("#apPaterno").val(tdArray[1].innerHTML);
		$("#apMaterno").val(tdArray[2].innerHTML);
		$("#email").val(tdArray[4].innerHTML);
		$("#estatus").val(tdArray[5].innerHTML);
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
		var apPaterno = $("#apPaterno").val();
		var apMaterno = $("#apMaterno").val();
		var email = $("#email").val();
		var estatus = $("#estatus").val();
		
		$.ajax({
			url: "gestionAlumno", 
			method: "POST",
			data: {
				operacion: operacion,
				boleta: boleta, 
				nombre: nombre, 
				apPaterno: apPaterno,
				apMaterno: apMaterno,
				email: email,
				estatus: estatus
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
	$("#apPaterno").val("");
	$("#apMaterno").val("");
	$("#email").val("");
	$("#estatus").val("");
}