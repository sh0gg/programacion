Algoritmo Preguntas
	Escribir 'FUNCION CALCULADORA'
	Escribir 'Elige tu operación'
	Escribir ' 1. Sumar '
	Escribir ' 2. Restar '
	Escribir ' 3. Multiplicar '
	Escribir ' 4. Dividir '
	Escribir ' Introduce un numero '
	Leer operacion
	Escribir 'Tipo de operación registrada'
	Escribir ' Dame un factor '
	Leer a
	Escribir 'Has escrito ', a
	Escribir ' Dame otro factor '
	Leer b
	Escribir 'Has escrito ', b
	Escribir 'Pensando...'
	Según operacion Hacer
		1:
			c <- a+b
			Escribir a, ' + ', b, ' es igual a ', c
		2:
			c <- a-b
			Escribir a, ' - ', b, ' es igual a ', c
		3:
			c <- a*b
			Escribir a, ' x ', b, ' es igual a ', c
		4:
			c <- a/b
			Escribir a, ' / ', b, ' es igual a ', c
		De Otro Modo:
			Escribir 'La has liado, reinicia el programa'
	FinSegún
FinAlgoritmo
