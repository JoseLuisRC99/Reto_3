function traerDatosCategory(){
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            pintarDatosCategory(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error de peticion");
        }
    });
}

function pintarDatosCategory(datos){
    let html="";
    html+= "<thead>;"
    html+= "<tr><th>Nombre</th><th>Descripcion</th></tr>";
    html+= "</thead>";

    html+="<tbody>";
    for (let i = 0; i<datos.length; i++){
        html+="<tr><td>"+datos[i].name+"</td>";
        html+="<td>"+datos[i].description+"</td></tr>";
    }

    html+="</tbody>";

    $("#tabla").empty();
    $("#tabla").append(html);
}

function guardarDatosCategory (){
    $.ajax ({

        url          : 'http://localhost:8080/api/Category/save',
        type         : 'POST',
        datatype     :  "JSON",
        contentType  : 'application/json',
            success      :  function(respuesta){
                alert("Inserción exitosa");
            },
            error       :   function(xhr,status){
                alert('Operacion no satisfactoria,'+ xhr.status );
            }

        }
    );
}
