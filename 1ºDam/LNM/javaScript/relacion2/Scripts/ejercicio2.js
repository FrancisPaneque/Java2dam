alert("2. Crea un script que acepte dos valores introducidos en decimal y muestre el resultado de la suma en binario y en hexadecimal. Utiliza asignación desectructurada.")

let numeroDecimal1 = prompt("Introduzca el primer número con decimales");

let numeroDecimal2 = prompt("Introduzca el segundo número con decimales");

let suma = numeroDecimal1 + numeroDecimal2;

alert("El resultado de la suma de decimales es: " + suma + ", siendo en binario: " + suma.toString(2) + " y para finalizar en hexadecimal: " + suma.toString(16));

