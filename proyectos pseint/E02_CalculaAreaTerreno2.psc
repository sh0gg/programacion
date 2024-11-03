Algoritmo E02_CalculaAreaTerreno2
	Escribir "Dame los datos H y R"
	Leer h
	Leer r
	catetoLargo<-raiz(h^2 - r^2)
	areaTrianRect<-(catetoLargo * r)/2
	areaTrianIsos<-areaTrianRect*2
	areaSemicirc<-(PI * r^2) / 2
	areaTotal<-areaSemicirc+areaTrianIsos
	Escribir "Tras calcular el área del triángulo isósceles " areaTrianIsos " metros cuadrados y el área de la semicircunferencia " areaSemicirc " metros cuadrados." 
	Escribir "Los sumamos y el área total de la figura es " areaTotal " metros cuadrados."
FinAlgoritmo
