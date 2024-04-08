/* 4. Leer el valor de la nota de un alumno y poner la nota correspondiente en texto. Por ejemplo, un 7.2 es notable*/

alert("4. Leer el valor de la nota de un alumno y poner la nota correspondiente en texto. Por ejemplo, un 7.2 es notable");

let nota;

do {

nota = prompt("Introduzca la nota del alumno (Escriba fin para finalizar el programa): ")

if ( nota >= 0 && nota < 5) {
    alert(`${nota} Esta suspenso`, nota)
} else if (nota >= 5 && nota < 6){
    alert(`${nota} es un suficiente`, nota)
} else if (nota >= 6 && nota < 7){
    alert(`${nota} es un bien`)
} else if (nota >= 7 && nota < 9){
    alert (`${nota} es un notable`)
} else if (nota >= 9 && nota <=10){
    alert(`${nota} es un sobresaliente`)
} else if (nota > 10){
    alert("La nota introducida es mayor de 10 (Introduzca un nota entro 0 y 10)");
} else if (nota < 10){
    alert("La nota introducida es menor de 0 (Introduzca un nota entro 0 y 10)")
}

} while (nota != "fin");
