Algoritmo Sumar_Numeros_Hasta0
	
	Escribir "¡Vamos a sumar!"
	Escribir "Dame un numero:"
	Leer x
	Escribir "Dame otro numero:"
	Leer n
	
	Mientras n > 0 Hacer
		Escribir x + n
		x <- x + n
		Escribir "Dame otro numero:"
		Leer n
	Fin Mientras
	
	Escribir x + n
	Escribir "No has sumado nada o has restado, se finaliza el programa."
FinAlgoritmo
