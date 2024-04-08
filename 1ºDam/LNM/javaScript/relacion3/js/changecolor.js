let btnRojo = document.getElementById('btnrojo');
let btnVerde = document.getElementById('btnverde');
let btnAzul = document.getElementById('btnazul');
let btnAmarillo= document.getElementById('btnamarillo');
let btnNaranja= document.getElementById('btnnaranja');
let btnReset = document.getElementById('btnreset');
let box = document.querySelector('.box');

function setColorRojo() {
  if(btnRojo.value == "rojo") {
    box.style.background = "#FF0000";
    btnRojo.style.background= "#FF0000";
  }
}

function enterCursorRojo() {
  btnRojo.style.background = "#F04848"
}

function leaveCursorRojo(){
  btnRojo.style.backgroundColor ="#bfdb1d"
}

function setColorVerde() {
  if(btnVerde.value == "verde") {
    box.style.background = "#00FF00";
    btnVerde.style.background= "#00FF00";
  }
}

function enterCursorVerde() {
  btnVerde.style.background = "#7CF966"
}

function leaveCursorVerde(){
  btnVerde.style.backgroundColor ="#bfdb1d"
}

function setColorAzul() {
  if(btnAzul.value == "azul") {
    box.style.background = "#0000FF";
    btnAzul.style.background= "#0000FF";
  }
}

function enterCursorAzul() {
  btnAzul.style.background = "#6697F9"
}

function leaveCursorAzul(){
  btnAzul.style.backgroundColor ="#bfdb1d"
}

function setColorAmarillo() {
  if(btnAmarillo.value == "amarillo") {
    box.style.background = "#FFFF00";
    btnAmarillo.style.background= "#FFFF00";
  }
}

function enterCursorAmarillo() {
  btnAmarillo.style.background = "#F8F54F"
}

function leaveCursorAmarillo(){
  btnAmarillo.style.backgroundColor ="#bfdb1d"
}

function setColorNaranja() {
  if(btnNaranja.value == "naranja") {
    box.style.background = "#FF9300";
    btnNaranja.style.background= "#FF9300";
  }
}

function enterCursorNaranja() {
  btnNaranja.style.background = "#F8B04F"
}

function leaveCursorNaranja(){
  btnNaranja.style.backgroundColor ="#bfdb1d"
}

function setColorReset() {
  if(btnReset.value == "reset") {
    box.style.background = "#000000";
    btnReset.style.background= "#000000";
  }
}

function enterCursorReset() {
  btnReset.style.background = "#444444"
}

function leaveCursorReset(){
  btnReset.style.backgroundColor ="#bfdb1d"
}

function changeColor(newColor) {
  var elem = document.getElementById("cabecera");
  elem.style.color = newColor;
}

let imagen = document.getElementsByTagName("img");
function cambiarImagen(){
  imagen[0].src = "imagen/imagen2.png";
}

let fecha = new Date;

let reloj = setInterval(()=>{
  fecha = new Date();
  let segundos = fecha.getSeconds();
  let valorSegundos;
  (segundos < 10) ? valorSegundos = "0" + segundos : valorSegundos = segundos;
  let minutos = fecha.getMinutes();
  let valorMinutos;
  (minutos < 10) ? valorMinutos = "0" +  minutos : valorMinutos = minutos;
  let horas = fecha.getHours();
  let valorHoras;
  (horas < 10) ? valorHoras = "0" + horas : valorHoras = horas;
  document.getElementById("reloj").innerHTML = valorHoras + ":" + valorMinutos + ":" + valorSegundos;
  }, 1000
);

let tiempoRespuesta = setTimeout(()=>{
  if (!confirm("¿Desea cambiar de pagina?")){
    window.open("https://www.xataka.com/");
  }
}, 180000);

let dimensiones = document.getElementById("dimensiones")
let ancho = document.documentElement.clientWidth;
let alto = document.documentElement.clientHeight;

let cambioDimnesiones = setInterval(() => {
  ancho = document.documentElement.clientWidth;
  alto = document.documentElement.clientHeight;
  dimensiones.innerHTML = ancho + " x " + alto;
  console.log (ancho + " x " + alto);
  }, 1000
);

