Algoritmo E02_CalculaAreaTerreno2
	Escribir "Dame los datos H y R"
	Leer h
	Leer r
	catetoLargo<-raiz(h^2 - r^2)
	areaTrianRect<-(catetoLargo * r)/2
	areaTrianIsos<-areaTrianRect*2
	areaSemicirc<-(PI * r^2) / 2
	areaTotal<-areaSemicirc+areaTrianIsos
	Escribir "Tras calcular el �rea del tri�ngulo is�sceles " areaTrianIsos " metros cuadrados y el �rea de la semicircunferencia " areaSemicirc " metros cuadrados." 
	Escribir "Los sumamos y el �rea total de la figura es " areaTotal " metros cuadrados."
FinAlgoritmo
