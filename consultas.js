 

function getDatosDeleteForm(){
	let params = new URLSearchParams(document.location.search.substring(1));
	console.log("params "+params)
	let parametroId = params.get("id"); 
	console.log("parametroId "+parametroId);

	let nombre = document.getElementById("nombre");
		

	let endpoint = "http://localhost:8080/api/alumnos/";
	//const msj = document.getElementById('msj');


	window.onload = function (e) {
	e.preventDefault();


	let arregloDatos= {};
			consutarDatos(arregloDatos);
	};

}

consutarDatos = function(data) {
	
	var url = endpoint+"contacto/"+parametroId;
	console.log(url);
	var json = data;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", url, true);
	xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
	xhr.onload = function () {
		if (xhr.status == 200 && xhr.response!='') {

	       let listaContactos = JSON.parse(xhr.responseText);

	       console.log('---'+listaContactos.nombre);
	       	
	       	 nombre.innerHTML= listaContactos.nombre;

	     
		} else {

			msj.innerHTML ="Error al guardar al contacto"
		}
		
	}
	xhr.send(null);

}

function mandaDelete(param){

	console.log("param de manda Delete");
	console.log(param)

	let elem = `/${param}`;
	let url = 'http://localhost:8080/api/alumnos'+elem;
	console.log(datos);
   var json = JSON.stringify(datos);

   // instanciando el metodo XMLHttp
   var request = new XMLHttpRequest();

   // Solicitando el metodo post con la url de nuestro servicio y true quiere decir que sera una peticion asincrona
   request.open("DELETE", url, true);
// seteando las cabeceras
   request.setRequestHeader('Content-type','application/json; charset=utf-8');
   // cuando la peticion empiece
   request.onload = function () {

	    if (request.readyState == 4 && request.status == "201") {
	        console.log(json);

	    } else {

	   		console.log(request.status, request.statusText)

	    }
	}

	request.send(json);

}


document.getElementById("btn_save_contact").addEventListener("click", (e) =>{
e.preventDefault();

	let data = {};

	//let data = new formData(document.getElementById("contacto_form"));

	let nombre = document.getElementById("nombre").value;
	let tel_1 = document.getElementById("tel_personal").value;
	let tel_2 = document.getElementById("tel_oficina").value;
	let email_1 = document.getElementById("email_personal").value;
	let email_2 = document.getElementById("email_oficina").value;
	let cumple = document.getElementById("cumple").value;


	data = {
		"nombre": nombre,
		"tel_personal": tel_1,
		"tel_oficina": tel_2,
		"email_personal": email_1,
		"email_oficina": email_2,
		"cumple": cumple
	}

	mandarParametros(data);


});
	


function mandarParametros(datos){
	let url = 'http://localhost:8080/api/alumnos';
	console.log(datos);
   var json = JSON.stringify(datos);

   // instanciando el metodo XMLHttp
   var request = new XMLHttpRequest();

   // Solicitando el metodo post con la url de nuestro servicio y true quiere decir que sera una peticion asincrona
   request.open("POST", url, true);
// seteando las cabeceras
   request.setRequestHeader('Content-type','application/json; charset=utf-8');
   // cuando la peticion empiece
   request.onload = function () {

	    if (request.readyState == 4 && request.status == "201") {

	        console.log(json);
	    } else {
	   		console.log(request.status, request.statusText)

	    }
	}
	request.send(json);
	// mostrarDatos();

}

function saveDatos(data) {
	let url = 'http://localhost:8080/api/alumnos';
	console.log("data")
	console.log(data);
	const request = new XMLHttpRequest();
	request.open('PUT', url, true);

	

	request.addEventListener('load', () => {
		console.log(request);
		if (request.status === 200) {
				 json = JSON.stringify(request.responseText);
				 console.log(json);
		}else{
			console.log(request.status, request.statusText)
		}
	});

	
	request.send(json);
}



function getDatos(){

	let url = 'http://localhost:8080/api/alumnos';

	const request = new XMLHttpRequest();

	request.open('GET', url, true);


	request.addEventListener('load', () => {
		console.log(request);
		if (request.status === 200) {
				// console.log(JSON.parse(request.responseText));
				let data = JSON.parse(request.responseText);

			 mostrarDatos(data);		

		}else{
			console.log(request.status, request.statusText)
		}
	});

	request.send(null);
}


function mostrarDatos(datos){
	document.getElementById("btn_contacts_all").addEventListener("click", (e) =>{
	e.preventDefault();

	let tablastr = `<table class="table table-hover">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">Nombre</th>
					      <th scope="col">Tel Personal</th>
					      <th scope="col">Tel Oficina</th>
					      <th scope="col">Email Personal</th>
					      <th scope="col">Email Oficina</th>
					      <th scope="col">Cumpleaños</th>
  					      <th scope="col">Opciones</th>
					    </tr>
					  </thead>
					  <tbody></tbody>`
           datos.forEach(item => {
             tablastr =  tablastr + `<tr>`
               for(prop in item){
               		if (prop !== "id") {
               			if (item[prop] !== null) {
               			   tablastr = tablastr + `<td> ${item[prop].toUpperCase()} </td>`           	
               			}
               		}
               }
               tablastr = tablastr + `<td>
	                        <p><a href="`+item[prop]+`" class="btn_azul" id="btn_editar">Editar</a>
	                        <a href="`+item[prop]+`" class="btn_azul" id="btn_borrar">Borrar</a></p>
	                   		 </td>`;
               tablastr =  `${tablastr} </tr>`
           })
        document.getElementById("container_table").innerHTML = tablastr;

	})
}





