Algoritmo Sumar_N_Numeros
	Escribir "�Tus amigos y tu quer�is comprar algo!"
	Leer objeto
	Escribir "�Cu�nto vale un/una " objeto "?"
	Leer precio
	Escribir "�Y cu�ntos amigos sois?"
	Leer amigos
	
	recaudadoAmigos<-0
	
	Mientras recaudadoAmigos < amigos Hacer
		recaudadoamigos <- recaudadoAmigos + 1
		Escribir "�Cuanto dinero pone el amigo n�mero " recaudadoAmigos "?"
		Leer aportacion
		totalAportado <- totalAportado + aportacion		
	Fin Mientras
	
	Si totalAportado < precio Entonces
		Escribir "Faltan " precio - totalAportado " para comprar un/una " objeto
	SiNo
		Escribir "�Con " totalAportado " pod�is comprar un/una " objeto "!"
	FinSi

	
FinAlgoritmo
