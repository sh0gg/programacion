import java.io.*;
public class calculadoraPseint {

	public static void main(String args[]) throws IOException {
		BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
		double a;
		double b;
		double c;
		int operacion;
		System.out.println("FUNCION CALCULADORA");
		System.out.println("Elige tu operacion");
		System.out.println(" 1. Sumar ");
		System.out.println(" 2. Restar ");
		System.out.println(" 3. Multiplicar ");
		System.out.println(" 4. Dividir ");
		System.out.println(" Introduce un numero ");
		operacion = Integer.parseInt(bufEntrada.readLine());
		System.out.println("Tipo de operacion registrada");
		System.out.println(" Dame un factor ");
		a = Double.parseDouble(bufEntrada.readLine());
		System.out.println("Has escrito "+a);
		System.out.println(" Dame otro factor ");
		b = Double.parseDouble(bufEntrada.readLine());
		System.out.println("Has escrito "+b);
		System.out.println("Pensando...");
		switch (operacion) {
		case 1:
			c = a+b;
			System.out.println(a+" + "+b+" es igual a "+c);
			break;
		case 2:
			c = a-b;
			System.out.println(a+" - "+b+" es igual a "+c);
			break;
		case 3:
			c = a*b;
			System.out.println(a+" x "+b+" es igual a "+c);
			break;
		case 4:
			c = a/b;
			System.out.println(a+" / "+b+" es igual a "+c);
			break;
		default:
			System.out.println("La has liado, reinicia el programa");
		}
	}


}

