

const cadena1 = prompt("Introduzca la primera cadena");
const cadena2 = prompt("Introduzca la segunda cadena");

if (cadena1.includes(cadena2)){
    alert("La segunda palabra introducida es subcadena");
} else {
    alert("La segunda palabra introducida no es subcadena")
}

alert("La longitud de la primera cadena es de: " + cadena1.length + " caracteres, y la longitud de la segunda es: " + cadena2.length + " caracteres");

const vocales = ["a", "e", "i", "o", "u"];

let cadena1May;

for (let i = 0; i < cadena1.length; i++) {
    if (cadena1.includes(vocales[i])) {
        cadena1May = cadena1[i].toUpperCase + cadena1.substring(i);
    }
}

alert("la primera cadena introducida tendria las siguientes vocales en mayuscula" + cadena1May);

let cadena1Cortada

if (cadena1.length > 5) {
    cadena1Cortada = cadena1.substring(0,5);
    alert("La primera cadena cortada es: " + cadena1Cortada +"...")
}

let cadena2May;

for (let i = 0; i < cadena2.length; i++) {
    if (cadena2.includes(vocales[i])) {
        cadena2May = cadena1[i].toUpperCase + cadena2.substring(i);
    }
}

alert("la primera cadena introducida tendria las siguientes vocales en mayuscula" + cadena2May);

let cadena2Cortada

if (cadena2.length > 5) {
    cadena2Cortada = cadena2.substring(0,5);
    alert("La segunda cadena cortada es: " + cadena2Cortada +"...")
}