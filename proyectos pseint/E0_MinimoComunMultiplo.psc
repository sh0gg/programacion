Funcion min <- mcm ( a,b )
	aBase <- a
	bBase <- b
	Si aBase < bBase Entonces
		Repetir
			a <- a + aBase
			Escribir "Añadiendo multiplos de " abase " : " a
			Si b < a Entonces
				b <- b + bBase
				Escribir "Añadiendo multiplos de " bbase " : " b
			FinSi
			Escribir "¿Es " a " igual a " b "?"
			Si a <> b Entonces
				Escribir "No son iguales, volvemos a sumar."
			FinSi
		Hasta Que a = b
		Escribir "¡Sí son iguales!"
		min <- a
	SiNo
		Repetir
			b <- b + bBase
			Escribir "Añadiendo multiplos de " bbase " : " b
			Si a < b Entonces
				a <- a + aBase
				Escribir "Añadiendo multiplos de " abase " : " a
			FinSi
			Escribir "¿Es " b " igual a " a "?"
			Si b <> a Entonces
				Escribir "No son iguales, volvemos a sumar."
			FinSi
		Hasta Que b = a
		Escribir "¡Sí son iguales!"
		min <- b
	FinSi
Fin Funcion

Algoritmo E0_MinimoComunMultiplo
	seguir <- 1
	Mientras seguir = 1 Hacer
		
		Escribir "Vamos a calcular el MCM de dos números"
		Escribir "Dime el primer número:"
		Leer a
		Escribir "Dime el segundo número:"
		Leer b
		
		min <- mcm (a,b)
		
		Escribir "El MCM es " min
		
		Escribir "¿Quieres calcular otro? (1 = Si, 2 = No)"
		Leer seguir
		
	Fin Mientras
	
FinAlgoritmo
