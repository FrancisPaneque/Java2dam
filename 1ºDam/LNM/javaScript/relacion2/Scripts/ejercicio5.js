alert("5. Crea un script que calcule la potencia de un número sin utilizar **, pow o cualquier función que realice la tarea directamente. La acción debe de ser con números y exponentes positivos. Crea una función que realice esta acción y que sea llamada cada vez que se introduzcan los valores")

let valor = prompt("Introduzca el valor a elevar");

let exponente = prompt("Introduzca el exponente al que quiere elevar el valor anteriormente introducido");

let res = 0;

if (valor == Number(valor)){

    if (valor >= 0) {
        res = valor
        for(let i = 0; i < potencia; i++) {
            resultado = resultado * valor;
        }
        alert("El resultado de la potencia es: " + resultado);
    }

} else {

    alert("introduzca un numero");

}
