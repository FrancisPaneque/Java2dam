// 2. Realiza la suma de los números que se introduzcan por teclado hasta que se lea un cero.

alert("2. Realiza la suma de los números que se introduzcan por teclado hasta que se lea un cero.");

let num1 ;
let res = 0;


while(num1 != 0){
    do {
        num1 = prompt("introduzca un valor: ",100)   
    } while (num1 == "")
    
    res = Number(num1) + Number(res);
    if (num1 == 0){
        alert(`el resultado de la suma es ${res}`, res)
    }
}
alert("Fin de las sumas");