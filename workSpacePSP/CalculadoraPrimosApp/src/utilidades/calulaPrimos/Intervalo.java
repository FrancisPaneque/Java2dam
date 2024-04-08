package utilidades.calulaPrimos;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Intervalo {
	
	public static List<Integer> primos = new ArrayList<>();
	private static void imprimePrimos() {
		
	}
	
	private static void buscaPrimos(int valor1Intervalo, int valor2Intervalo) {
		
		for (int i = valor1Intervalo; i <= valor2Intervalo; i++) {
			if (esPrimo(i)) {
				primos.add(i);
			}
		}
	}

	private static boolean esPrimo(int valor) {
		// Caso especial: 0 y 1 no son primos
        if (valor <= 1) {
            return false;
        }

        // Comprobar divisibilidad por números del 2 hasta la raíz cuadrada del número
        for (int i = 2; i <= Math.sqrt(valor); i++) {
            if (valor % i == 0) {
                // Si el número es divisible por algún otro número, no es primo
                return false;
            }
        }

        // Si no se encontraron divisores, el número es primo
        return true;
	}
	
	
}
