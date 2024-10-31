Algoritmo E09_Maior3
	Escribir "Vamos a comprobar cual de los siguientes números es mayor"
	Escribir "Dame un valor 1"
	Leer x1
	Escribir "Dame un valor 2"
	Leer x2
	Escribir "Dame un valor 3"
	Leer x3
	
	Si x1 > x2 Entonces
		Si x1 > x3 Entonces
			Escribir x1 " es mayor que " x2 " y " x3
		SiNo
			Escribir x3 " es mayor que " x1 " y " x2
		FinSi
	SiNo
		Si x2 > x3 Entonces
			Escribir x2 " es mayor que " x1 " y " x3
		SiNo
			Escribir x3 " es mayor que " x1 " y " x2
		FinSi
	FinSi
FinAlgoritmo
