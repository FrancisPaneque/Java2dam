let valor = prompt("Introduzca un valor:", 100);

alert (typeof(valor));

if (valor == null){
    alert("Introduzca un valor valido");
} else if(valor[0] == " ") {
    alert("ha introducido un valor nulo")
}
alert (`El valor introducido es: ${valor}`, valor)

