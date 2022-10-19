function traerDatosClient(){
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            pintarDatosClient(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error de peticion");
        }
    });
}

function pintarDatosClient(datos){
    let html="";
    html+= "<thead>;"
    html+= "<tr><th>Email</th><th>Contraseña</th><th>Nombre</th><th>Edad</th></tr>";
    html+= "</thead>";

    html+="<tbody>";
    for (let i = 0; i<datos.length; i++){
        html+="<tr><td>"+datos[i].email+"</td>";
        html+="<tr><td>"+datos[i].password+"</td>";
        html+="<tr><td>"+datos[i].name+"</td>";
        html+="<td>"+datos[i].age+"</td></tr>";
    }

    html+="</tbody>";

    $("#tabla").empty();
    $("#tabla").append(html);
}