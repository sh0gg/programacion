Algoritmo E01CalculoAreaTerreno
	Escribir "Dame los datos A, B y C"
	Leer a
	Leer b
	Leer c
	
	Escribir "El �rea del terreno se calcula sumando " b " x " c " para el rect�ngulo inferior sumado a (" a " - " c ") x " b " / 2 del tri�ngulo superior."
	areaRect<-b * c
	altTrian<-a - c
	areaTrian<- (altTrian * b)/2
	areaTotal<- areaRect + areaTrian
	
	Escribir "El �rea del rect�ngulo y el tri�ngulo son " areaRect " y " areaTrian "metros cuadrados , respectivamente. En total " areaTotal "."
FinAlgoritmo
