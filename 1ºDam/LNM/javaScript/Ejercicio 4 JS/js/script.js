const IMAGENES=[
    "./images/drift-car.gif",
    "./images/image1.jpg",
    "./images/image2.jpg"
]

let posicion=0;

anterior.addEventListener("click", fotoAnterior);
siguiente.addEventListener("click", fotoSiguiente);
function fotoSiguiente(){
    (posicion == IMAGENES.length-1)
        ?posicion = 0
        :posicion++
    ;
   cargarImagen();

}
function fotoAnterior(){
    (posicion == 0)
        ?posicion = IMAGENES.length-1
        :posicion--
    ;
    console.log(posicion);
    cargarImagen();
}

function cargarImagen(){
    let imagen = document.getElementsByTagName("img");
    imagen[0].src = IMAGENES[posicion];
}

function mostrarMensaje(){
    alert('Este es el botón creado con JavaScript');
}

alerta.addEventListener("click", mostrarMensaje);

function ocultarBoton(){
    document.getElementById("ocultar").style.display = "none";
}

function mostrarOcultarTexto() {
    var texto = document.getElementById("texto");
    if (texto.style.display === "none") {
        texto.style.display = "block";
    } else {
        texto.style.display = "none";
    }
}

function mostrarMensaje1(){
    alert('Primer mensaje de alerta');
    boton.removeEventListener("click", mostrarMensaje1);
    boton.addEventListener("click", mostrarMensaje2);
}

function mostrarMensaje2(){
    alert('Segundo mensaje de alerta');
}

var boton = document.getElementById("dobleAlerta");
boton.addEventListener("click", mostrarMensaje1);