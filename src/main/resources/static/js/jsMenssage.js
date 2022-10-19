function traerDatosMessage(){
    $.ajax({
        url: "http://localhost:8080/api/Message/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            pintarDatosMessage(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error de peticion");
        }
    });
}

function pintarDatosMessage(datos){
    let html="";
    html+= "<thead>;"
    html+= "<tr><th>Mensaje</th></tr>";
    html+= "</thead>";

    html+="<tbody>";
    for (let i = 0; i<datos.length; i++){
        html+="<tr><td>"+datos[i].messageText+"</td></tr>";
    }

    html+="</tbody>";

    $("#tabla").empty();
    $("#tabla").append(html);
}