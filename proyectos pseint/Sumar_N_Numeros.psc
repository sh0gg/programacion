Algoritmo Sumar_N_Numeros
	Escribir "¡Tus amigos y tu queréis comprar algo!"
	Leer objeto
	Escribir "¿Cuánto vale un/una " objeto "?"
	Leer precio
	Escribir "¿Y cuántos amigos sois?"
	Leer amigos
	
	recaudadoAmigos<-0
	
	Mientras recaudadoAmigos < amigos Hacer
		recaudadoamigos <- recaudadoAmigos + 1
		Escribir "¿Cuanto dinero pone el amigo número " recaudadoAmigos "?"
		Leer aportacion
		totalAportado <- totalAportado + aportacion		
	Fin Mientras
	
	Si totalAportado < precio Entonces
		Escribir "Faltan " precio - totalAportado " para comprar un/una " objeto
	SiNo
		Escribir "¡Con " totalAportado " podéis comprar un/una " objeto "!"
	FinSi

	
FinAlgoritmo
