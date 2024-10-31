Funcion maximo <- max ( a, b )
	Si a > b Entonces
		maximo = a
	SiNo
		maximo = b
	FinSi
Fin Funcion

Algoritmo E18_Maximo
	
	Escribir "Vamos a calcular el máximo común divisor de dos números"
	Escribir "Dame el primer número"
	Leer a
	Escribir "Dame el segundo número"
	Leer b
	
	numMaximo <- max (a, b)
	
	Escribir "El máximo es " numMaximo
	
FinAlgoritmo
