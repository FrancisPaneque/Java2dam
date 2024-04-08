/* 5. Introducir 10 valores en un array, mostrar la suma de sus valores, el mayor valor, el menor 
valor y la media de los valores.*/

let array = [];
let suma = 0;

alert("5. Introducir 10 valores en un array, mostrar la suma de sus valores, el mayor valor, el menor valor y la media de los valores.");

for (let i = 0; i <= 9; i++){
    let entrada = Number(prompt("Introduzca el valor: "));
    if ( entrada == Number(entrada)){
        array.push(entrada);
        suma = array[i] + suma;
    } else if ( entrada == null) {
        alert("introduzca un número");
    }
}

let media = suma / array.length;

let mayor = array[0];
let menor = array[0];

for (let i = 0; i < array.length; i++){
    if (mayor < array[i]){
        mayor = array[i];
    }
    if (menor > array[i]){
        menor = array[i];
    }
}

alert(`La suma de los valores introducidos es de ${suma} y su media es de ${media} `, suma, media);
alert(`El valor maximo es ${mayor} y el menor ${menor}`, mayor, menor);