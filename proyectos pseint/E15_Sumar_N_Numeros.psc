Algoritmo E15_Sumar_N_Numeros
	Escribir "¡Tus amigos y tu queréis comprar algo!"
	Leer objeto
	Escribir "¿Cuánto vale un/una " objeto "?"
	Leer precio
	Escribir "¿Y cuántos amigos sois?"
	Leer amigos
	
	amigosAportaron<-0
	
	Mientras amigosAportaron < amigos Hacer
		amigosAportaron <- amigosAportaron + 1
		Escribir "¿Cuanto dinero pone el amigo número " amigosAportaron "?"
		Leer aportacion
		totalAportado <- totalAportado + aportacion		
	Fin Mientras
	
	Si totalAportado < precio Entonces
		Escribir "Faltan " precio - totalAportado " para comprar un/una " objeto
	SiNo
		Escribir "¡Con " totalAportado " podéis comprar un/una " objeto "!"
	FinSi

	
FinAlgoritmo
