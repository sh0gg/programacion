Algoritmo E08_DescontoTraxes
	Escribir "Almac�ns O harapento distinguido"
	Escribir "===================="
	Escribir "�OFERTA ESPECIAL! COMPRAS DE +250e TIENEN UN 15% DE DESCUENTO!"
	Escribir "El resto solo un 8%, pero bueno, �algo es algo!"
	Escribir "===================="
	Escribir "�Cuanto va a gastar hoy?"
	
	Leer gasto
	
	Si gasto > 250 Entonces
		gasto<-gasto-(gasto*0.15)
		
		Escribir "Se le aplicar� un descuento del 15% por lo que su total es de " gasto " euros"
		
	SiNo
		gasto<-gasto-(gasto*0.08)
		
		Escribir "Se le aplicar� un descuento del 8% por lo que su total es de " gasto " euros"
	FinSi
	
	
FinAlgoritmo
