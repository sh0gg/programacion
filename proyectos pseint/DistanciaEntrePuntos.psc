Algoritmo DistanciaEntrePuntos
	
	Escribir "Ingrese las coordenadas de P1 (X1, Y1): "
    Leer X1
	Leer Y1
    Escribir "Ingrese las coordenadas de P2 (X2, Y2): "
    Leer X2
	Leer Y2
	
	distancia <- raiz((X2 - X1)^2 + (Y2 - Y1)^2)
	
	Escribir "La distancia entre los puntos es: " distancia
FinAlgoritmo
