Funcion suma <- sumaC ( a , b )
	suma <- a + b
	
Fin Funcion

Algoritmo SumaDosNumerosHastaQue

	Mientras a >= 0 y b >= 0 Hacer
		Escribir "Dame un número:"
		Leer a
		Escribir "Dame otro número:"
		Leer b
		
		suma <- sumaC (a, b)
		
		Escribir "La suma es " suma
	Fin Mientras
	
FinAlgoritmo
