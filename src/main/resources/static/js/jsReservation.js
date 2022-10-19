function traerDatosReservation(){
    $.ajax({
        url: "http://localhost:8080/api/Reservation/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            pintarDatosReservation(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error de peticion");
        }
    });
}

function pintarDatosReservation(datos){
    let html="";
    html+= "<thead>;"
    html+= "<tr><th>Nombre</th><th>Descripcion</th></tr>";
    html+= "</thead>";

    html+="<tbody>";
    for (let i = 0; i<datos.length; i++){
        html+="<tr><td>"+datos[i].startDate+"</td>";
        html+="<tr><td>"+datos[i].devolutionDate+"</td>";
        html+="<td>"+datos[i].status+"</td></tr>";
    }

    html+="</tbody>";

    $("#tabla").empty();
    $("#tabla").append(html);
}