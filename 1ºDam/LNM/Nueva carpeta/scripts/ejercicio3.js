/* 3. Leer 4 valores numéricos de una cifra. Esos valores en realidad son un solo número y 
habrá que escribirlo por pantalla completo. Por ejemplo, introduzco el 1, 2, 3 y 4. El resultado es 1234.*/

alert("3. Leer 4 valores numéricos de una cifra. Esos valores en realidad son un solo número y habrá que escribirlo por pantalla completo. Por ejemplo, introduzco el 1, 2, 3 y 4. El resultado es 1234.");

let num;
let res = 0;

for (let i = 0; i < 4; i++) {
    num = Number(prompt("Introduzca un valor: "));

   res = (10 * res) + num;

}

alert(`El resultado es ${res}`, res);