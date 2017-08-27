
/**
 * clase javascript para formulario registrarUsuario
 */
function RegistarUsuarioSistema(nombre, apellido, sexo, fechaNacimiento, email,
		codigoUsuario, password, password2, emailAlternativa, direccion,telefono, celular) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.sexo = sexo;
	this.fechaNacimiento = fechaNacimiento;
	this.email = email;
	this.codigoUsuario = codigoUsuario;
	this.password = password;
	this.password2 = password2;
	this.emailAlternativa = emailAlternativa;
	this.direccion = direccion;
	this.telefono = telefono;
	this.celular = celular;
}

/**
 * Metodo javascript para optener los datos del formulario
 */
function optenerValoresFormularioRegistrar() {

	entering("optenerValoresFormulario");
	var nombre = optenerValorCampo("nombre");
    var apellido =  optenerValorCampo("apellido");
	var sexo= optenerValorRadioButton("sexo");
//	var fechaNacimiento= optenerValorCampo("fechaNacimiento");				
	var email= optenerValorCampo("email");					
	var codigoUsuario= optenerValorCampo("codigoUsuario");						
	
	var passwordValida = validarCoincidenciaPassword("password", "password-2");
	console.log("Las password son valida : "+passwordValida );
	if (passwordValida) {
		var password = document.getElementById("password").value;				
		var password2 = document.getElementById("password-2").value;
	}
	
	//datos opcionales 
	var emailAlternativa = document.getElementById("emailAlternativa");
	if (emailAlternativa.value.length > 1 && emailAlternativa != undefined && emailAlternativa.value != null){
		emailAlternativa = optenerValorCampo("emailAlternativa");
	}
	
	var direccion= document.getElementById("direccion");
	if (direccion.value.length > 1 && direccion.value !='' && direccion != undefined && direccion.value != null){
		direccion= optenerValorCampo("direccion");
	}
						
	var telefono= document.getElementById("telefono");
	if (telefono.value.length > 1 && telefono.value !='' && telefono != undefined && telefono.value != null){
		telefono= optenerValorCampo("direccion");
	}
	
	var celular= document.getElementById("celular");
	if (celular.value.length > 1 && celular.value !='' && celular != undefined && celular.value != null){
		celular= optenerValorCampo("celular");
	}
	
	console.log("nombre"+ nombre);
	console.log("apellido"+ apellido);
	console.log("email"+ email);
	console.log("codigoUsuario"+ codigoUsuario);
	console.log("sexo: "+ sexo);
	console.log("email: "+ email);
	console.log("password1: "+ password);
	console.log("password2: "+ password2);
	
	alert("terminando regitrar usuario.");
}

function optenerValorRadioButton(idRadio){
	
	var radios = document.getElementsByName(idRadio);
	var value;
	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
	        // do whatever you want with the checked radio
	    	value = radios[i].value;

	        // only one radio can be logically checked, don't check the rest
	        break;
	    }
	}
	return value;
}


function validarCoincidenciaPassword(pass1 , pass2){
	
	var coincidenciaPassword =  false;
	//opteniendo variables password 
	var p1 = document.getElementById(pass1).value;
	var p2 = document.getElementById(pass2).value;
	
	//validando la password no estan vacias
	if (p1.length == 0 || p2.length == 0) {
		  console.log("Los campos de la password no pueden quedar vacios");
		  return false;
	}
	var pass1SinEspacio = validarNoEspaciosPalabra(p1);
	var pass2SinEspacio = validarNoEspaciosPalabra(p2);
	
	if (pass1SinEspacio && pass2SinEspacio) {
		console.log("Los campos de las password no contienen espacios en blanco.");
		if (p1 != p2) {
			console.log("Las passwords deben de coincidir");
			coincidenciaPassword= false;
		} else {
			console.log("Todo esta correcto");
			coincidenciaPassword= true;
		}
	}
	return coincidenciaPassword;
	
}

function validarNoEspaciosPalabra(palabra){
	
	console.log("validando las password no contengan espacios");
	//validando las password no contengan espacios
	var espacios = true;
	var cont = 0;
	 
	while (espacios && (cont < palabra.length)) {
	  if (palabra.charAt(cont) == " "){
		console.log("Las password contiene un espacios");
	    espacios = false;
	    break;
	  }
	  cont++;
	}
	return espacios;
}

