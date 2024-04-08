const open = document.getElementById('open');
const modal_container = document.getElementById('modal_container');
const close = document.getElementById('close');

open.addEventListener('click', () => {
  modal_container.classList.add('show');  
});

close.addEventListener('click', () => {
  modal_container.classList.remove('show');
});

const open2 = document.getElementById('open2');

//javaScript boton
function mostrarMensaje(){
  alert('Este es el botón creado con JavaScript');
}

alerta.addEventListener("click", mostrarMensaje);

//muestra y oculta el texto
function mostrarOcultarTexto() {
  var texto = document.getElementById("texto");
  if (texto.style.display === "none") {
      texto.style.display = "block";
  } else {
      texto.style.display = "none";
  }
}
//doble alerta
open2.addEventListener('click', () => {
  alert("Mensaje 1");
  alert("Mensaje 2");  
});
