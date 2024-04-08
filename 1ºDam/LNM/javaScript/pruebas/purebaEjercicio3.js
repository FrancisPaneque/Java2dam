let num;
let res;

do {
    let repetidor = 1;
    repetidor++;

    num = prompt(`Introduzca el valor numero ${repetidor}`, repetidor);

    res = num + res;


} while ( repetidor != 4)

alert(`El resultado es ${res}`, res);