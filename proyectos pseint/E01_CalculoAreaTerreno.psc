Algoritmo E01CalculoAreaTerreno
	Escribir "Dame los datos A, B y C"
	Leer a
	Leer b
	Leer c
	
	Escribir "El área del terreno se calcula sumando " b " x " c " para el rectángulo inferior sumado a (" a " - " c ") x " b " / 2 del triángulo superior."
	areaRect<-b * c
	altTrian<-a - c
	areaTrian<- (altTrian * b)/2
	areaTotal<- areaRect + areaTrian
	
	Escribir "El área del rectángulo y el triángulo son " areaRect " y " areaTrian "metros cuadrados , respectivamente. En total " areaTotal "."
FinAlgoritmo
