Funcion mostrarMenu
    Escribir "1. Iniciar sesi�n"
    Escribir "2. Listar gatos"
    Escribir "0. SALIR"
Fin Funcion

Funcion mostrarSubMenu
    Escribir "1. Gatos guardados"
    Escribir "2. Adoptar gatito"
	Escribir "3. Subir foto gatito"
	Escribir "4. Cerrar sesi�n"
    Escribir "0. SALIR"
Fin Funcion

Funcion opcionUsuario <- menu
    Repetir
        mostrarMenu
        Escribir "Elige una opci�n: "
        Leer opcionUsuario
    Hasta Que opcionUsuario >= 0 y opcionUsuario <= 2
Fin Funcion
	
Funcion opcionUsuarioSub <- subMenu
	nombreUsuario <- "admin"
	contrase�a <- "abc123.,"
	fallos <- 0
	Repetir
		Escribir "Nombre de usuario: "
		Leer userName
		Escribir "Contrase�a: "
		Leer passWord
		Escribir "Nombre de usuario o contrase�a err�neos"
		fallos <- fallos + 1
	Hasta Que userName = nombreUsuario y passWord = contrase�a o fallos > 3
	 
	Escribir "�Has hecho login correctamente!"
	
	Repetir
		mostrarSubMenu
		Escribir "Elige una opci�n: "
		Leer opcionUsuarioSub
	Hasta Que opcionUsuarioSub >= 0 y opcionUsuarioSub <= 4
FinFuncion
	
Algoritmo E20_Menu_SubMenu
	
	Repetir
		opt <- menu
		Escribir "La opci�n elegida es: ", opt
		Si opt == 1 Entonces
			Repetir
				optSub <- subMenu
				Escribir "La opci�n elegida es: ", optSub
			Hasta Que optSub == 4
		FinSi
	Hasta Que opt == 0
	
Escribir "Fin del programa"
	
FinAlgoritmo
