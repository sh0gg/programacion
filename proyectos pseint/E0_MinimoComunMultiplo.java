/* Este codigo ha sido generado por el modulo psexport 20230113-w32 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo debería llamarse "E0_MinimoComunMultiplo.java."

// Hay dos errores que se pueden generar al exportar un algoritmo con subprocesos desde PSeint a Java:
// 1) En java no se puede elegir entre pasaje por copia o por referencia. Técnicamente solo existe el
// pasaje por copia, pero los identificadores de objetos representan en realidad referencias a los
// objetos. Entonces, el pasaje para tipos nativos actúa como si fuera por copia, mientras que el
// pasaje para objetos (como por ejemplo String) actúa como si fuera por referencia. Esto puede llevar
// a que el algoritmo exportado no se comporte de la misma forma que el algoritmo original, en cuyo
// caso deberán modificarse algunos métodos (subprocesos exportados) para corregir el problema.
// 2) Las funciones que hacen lectura por teclado deben lazar una excepción. Si una función A es
// invocada por otra B, B también debe manejar (lanzar en este caso) las execpciones que lance A.
// Esto no se cumple en el código generado automáticamante: las funciones que realizan lecturas
// directamente incluyen el código que indica que pueden generar dicha excepción, pero las que
// lo hacen indirectamente (invocando a otras que sí lo hacen), puede que no, y deberán ser
// corregidas manualmente.

import java.io.*;

public class e0_minimocomunmultiplo {

	public static SIN_TIPO mcm(SIN_TIPO a, SIN_TIPO b) {
		double a;
		double a);;
		double abase;
		double b;
		double b);;
		double bbase;
		double min;
		abase = a;
		bbase = b;
		if (abase>bbase) {
			do {
				a = a+abase;
				System.out.println("Añadiendo multiplos de "+abase+" : "+a);
				if (b<a) {
					b = b+bbase;
					System.out.println("Añadiendo multiplos de "+bbase+" : "+b);
				}
				System.out.println("¿Es "+a+" igual a "+b+"?");
				if (a!=b) {
					System.out.println("No son iguales, volvemos a sumar.");
				}
			} while (a!=b);
			System.out.println("¡Sí son iguales!");
			min = a;
		} else {
			do {
				b = b+bbase;
				System.out.println("Añadiendo multiplos de "+bbase+" : "+b);
				if (a<b) {
					a = a+abase;
					System.out.println("Añadiendo multiplos de "+abase+" : "+a);
				}
				System.out.println("¿Es "+b+" igual a "+a+"?");
				if (b!=a) {
					System.out.println("No son iguales, volvemos a sumar.");
				}
			} while (b!=a);
			System.out.println("¡Sí son iguales!");
			min = b;
		}
		return min;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
		int a;
		int b;
		String mcm[][];
		String min;
		double seguir;
		seguir = 1;
		while (seguir==1) {
			System.out.println("Vamos a calcular el MCM de dos números");
			System.out.println("Dime el primer número:");
			a = bufEntrada.readLine();
			System.out.println("Dime el segundo número:");
			b = bufEntrada.readLine();
			min = mcm[a-1][b-1];
			System.out.println("El MCM es "+min);
			System.out.println("¿Quieres calcular otro? (1 = Si, 2 = No)");
			seguir = Double.parseDouble(bufEntrada.readLine());
		}
	}


}

