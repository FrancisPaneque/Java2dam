/* 6. Introducir 10 valores en una línea separada por espacios en blancos. En un array deben de 
introducirse los valores pares y en otro los impares. */

alert("6. Introducir 10 valores en una línea separada por espacios en blancos. En un array deben de introducirse los valores pares y en otro los impares.");

let valores = prompt ('Introduce la cantidad de números que quieras separadas de espacios', 1);
alert(valores);

let original = [];

if ((valores[0] == null)) {
    alert("El valor está vacio");
} else {
    let control = 0;

    for(let i = 0; i <= valores.length-1; i++){
        if (valores[i] != " "){
            if (original[control] == undefined){
                original[control] =  valores[i];
            }else{
                original[control] = original[control] + valores[i];
            }
        } else{
            control++;
        }
    }
}

alert(`La lista original es: ${original} `,original);

let pares = [];
let impares = [];

for (let i = 0; i < original.length; i++){
    if (original[i] % 2 == 0){
        pares.push(original[i])
    } else {
        impares.push(original[i])
    }
}

alert(`La lista de pares es: ${pares}`);
alert(`La lista de impares es: ${impares}`);