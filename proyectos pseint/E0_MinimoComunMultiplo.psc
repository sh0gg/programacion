Funcion min <- mcm ( a,b )
	aBase <- a
	bBase <- b
	Si aBase < bBase Entonces
		Repetir
			a <- a + aBase
			Escribir "A�adiendo multiplos de " abase " : " a
			Si b < a Entonces
				b <- b + bBase
				Escribir "A�adiendo multiplos de " bbase " : " b
			FinSi
			Escribir "�Es " a " igual a " b "?"
			Si a <> b Entonces
				Escribir "No son iguales, volvemos a sumar."
			FinSi
		Hasta Que a = b
		Escribir "�S� son iguales!"
		min <- a
	SiNo
		Repetir
			b <- b + bBase
			Escribir "A�adiendo multiplos de " bbase " : " b
			Si a < b Entonces
				a <- a + aBase
				Escribir "A�adiendo multiplos de " abase " : " a
			FinSi
			Escribir "�Es " b " igual a " a "?"
			Si b <> a Entonces
				Escribir "No son iguales, volvemos a sumar."
			FinSi
		Hasta Que b = a
		Escribir "�S� son iguales!"
		min <- b
	FinSi
Fin Funcion

Algoritmo E0_MinimoComunMultiplo
	seguir <- 1
	Mientras seguir = 1 Hacer
		
		Escribir "Vamos a calcular el MCM de dos n�meros"
		Escribir "Dime el primer n�mero:"
		Leer a
		Escribir "Dime el segundo n�mero:"
		Leer b
		
		min <- mcm (a,b)
		
		Escribir "El MCM es " min
		
		Escribir "�Quieres calcular otro? (1 = Si, 2 = No)"
		Leer seguir
		
	Fin Mientras
	
FinAlgoritmo
