alert("6. Realiza un script que muestre la tabla de multiplicar del valor introducido por teclado del 1 al 10. Una vez hecho esto se le preguntará si desea continuar. En el caso de que así sea, se continuará con los 10 siguientes números, así hasta que se le pulse cancelar. Debe de utilizarse una función flecha.")

let factor = prompt("Introduzca el valor del que quiera saber su tabla de multiplicar (valor entre 1 y 10) ");

if (factor >= 1 && factor <= 10) {

    for (let i = 0; i <= 10; i++ ){
        
        alert(factor + " x " + i + " = " + factor * i);
    }

} else {
    alert("Introduzca un valor entre 1 y 10");
}