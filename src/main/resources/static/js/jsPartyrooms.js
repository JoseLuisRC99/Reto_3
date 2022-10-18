function traerDatos(){
    $.ajax({
        url: "http://localhost:8080/api/Partyroom/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            pintarDatos(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error de peticion");
        }
    });
}

function pintarDatos(datos){
    let html="";
    html+= "<thead>;"
    html+= "<tr><th>Salon</th><th>Dueño</th><th>Capacidad</th><th>Descripcion</th><th>Categoria</th></tr>";
    html+= "</thead>";

    html+="<tbody>";
    for (let i = 0; i<datos.length; i++){
        html+="<tr><td>"+datos[i].name+"</td>";
        html+="<td>"+datos[i].owner+"</td>";
        html+="<td>"+datos[i].capacity+"</td>";
        html+="<td>"+datos[i].category.name+"</td></tr>";
    }

    html+="</tbody>";

    $("#tabla").empty();
    $("#tabla").append(html);
}