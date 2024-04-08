alert("1. Crea un objeto cuyo contenido sea el número ordinal y como valor el número cardinal, es decir, 1: primero, 2: segundo… hasta el 10: décimo. Crea una función que cada vez que se introduzca el número ordinal nos dé como resultado el cardinal del número, hasta que se introduzca un número distinto del 1 al 10 o cualquier otro valor. Utiliza la instrucción for..in. HAY QUE HACERLO CON OBJETOS.")

let numeros = new Object();
numeros = {
    primero: 1,
    segundo: 2,
    terccero: 3,
    cuarto: 4,
    quinto: 5,
    sexto: 6,
    septimo: 7,
    octavo: 8,
    noveno: 9,
    decimo: 10
}

let numero;

do {
    numero = prompt("Introduzca un numero entre 1 y 10 para saber su forma ordinal(Introduzca 0 para finalizar)");
    if (numero >= 1 && numero <= 10){
        for (let property in numeros){
            if (numeros[property] == numero) {
            alert(property + "es el:" + numeros[property]);
            }
        }
    } else {
        alert("Introduzca un valor entre 1 y 10");
    }
} while (numero != 0);
/*
let numeroCardinal;

do {
numeroCardinal = Number(prompt("Introduzca un numero ordinal para saber su cardinal (introduzca 0 para terminar el programa)"));
alert(numeros.numeroCardinal);
} while ( numeroCardinal != 0); */