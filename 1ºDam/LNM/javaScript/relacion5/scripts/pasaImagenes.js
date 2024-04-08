// modo Oscuro

modoOscuro.addEventListener("click", toggleDarkMode);

let modoOscuroAct = false;

function toggleDarkMode() {
    let cuerpo = document.querySelector('body');
    cuerpo.classList.toggle('dark-mode');
    modoOscuroAct = !modoOscuroAct;
    localStorage.setItem(!'ModoOscuroActivado',modoOscuroAct);

}

window.onload = ()=> {
    let savedMode = localStorage.getItem('ModoOscuroActivado');
    if (savedMode === 'true') {
        toggleDarkMode();
    }
}


// EJERCICIO 1

const IMAGENES = [

    "./imagenes/capibara1.jpg",
    "./imagenes/tucan2.jpg",
    "./imagenes/capibara3.jpg",
    "./imagenes/perezoso4.jpg",
    "./imagenes/cerdo5.jpg",
    "./imagenes/zebra6.jpg",
    "./imagenes/tortuga7.jpg"

];

let posicion = 0;

anterior.addEventListener("click", fotoAnterior);
siguiente.addEventListener("click", fotoSiguiente);

function fotoSiguiente(){
    
    (posicion == IMAGENES.length - 1) ? posicion = 0 : posicion++;

    pasaImagenes();
}

function fotoAnterior(){
    
    (posicion == 0) ? posicion = IMAGENES.length - 1 : posicion--;

    pasaImagenes();
}

function pasaImagenes(){
    let imagen = document.getElementById("imagen1");

    imagen.src = IMAGENES[posicion];

}
// EJERCICIO 2

let currentIndex = 0;
let intervalId = null;

function cambiarImagenes() {
  document.getElementById("imagen2").src = IMAGENES[currentIndex];
  currentIndex++;

  if (currentIndex === IMAGENES.length) {
    currentIndex = 0;
  }
}

function empezarCambioAutomatico() {
  intervalId = setInterval(cambiarImagenes, 2000);
}

function pausarCambioAutomatico() {
  clearInterval(intervalId);
}

document.getElementById("empezar").addEventListener("click", empezarCambioAutomatico);
document.getElementById("pausar").addEventListener("click", pausarCambioAutomatico);

// Agregamos el siguiente código para deshabilitar el botón correspondiente cuando sea necesario

document.getElementById("empezar").addEventListener("click", function() {
  document.getElementById("empezar").disabled = true;
  document.getElementById("pausar").disabled = false;
});

document.getElementById("pausar").addEventListener("click", function() {
  document.getElementById("empezar").disabled = false;
  document.getElementById("pausar").disabled = true;
});