const LONGITUD_ARRAY = 50;
const FIN_RANGO = 120;
const INICIO_RANGO = 1;

// creamos el array
let arrayNumerosAleatorios = new Array(LONGITUD_ARRAY);

// rellenamos la array
for (let i = 0; i < LONGITUD_ARRAY - 1; i++ ){
    arrayNumerosAleatorios[i] = Math.random() * (FIN_RANGO - INICIO_RANGO + 1 ) + INICIO_RANGO;
}

// buscamos los numeros mayores a 50 y los metemos en el array mayor de 50
for (let i = 0; i < LONGITUD_ARRAY - 1; i++ ){
    if (arrayNumerosAleatorios[i] >= 50) {
        alert(`los numeros mayores de 50 son: ${arrayNumerosAleatorios} `, arrayNumerosAleatorios);
    }

    if (i = 49)
    break;
}

// repetimos el mismo paso con los numeros menores de 40
for (let j = 0; j < LONGITUD_ARRAY - 1; j++ ){
    if (arrayNumerosAleatorios[j] <= 40) {
        alert(`los numeros menores de 40 son: ${arrayNumerosAleatorios} `, arrayNumerosAleatorios);
    }

    if(j = 49)
    break;
}

// buscamos el numero mayor y menor
let mayor = arrayNumerosAleatorios[0];
let menor = arrayNumerosAleatorios[0];

for (let i = 0; i < LONGITUD_ARRAY - 1; i++){
    if (mayor < arrayNumerosAleatorios[i]){
        mayor = arrayNumerosAleatorios[i];
    }
    if (menor > arrayNumerosAleatorios[i]){
        menor = arrayNumerosAleatorios[i];
    }
}
// imprimimos el maximo y minimo
alert(`El valor maximo es ${mayor} y el menor ${menor}`, mayor, menor);


