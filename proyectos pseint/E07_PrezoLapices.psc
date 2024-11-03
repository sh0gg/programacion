Algoritmo E07_PrezoLapices
    Escribir "Introduce la cantidad de lápices:"
    Leer cantidad
    Si cantidad >= 1000 Entonces
        precio <- 0.85
    SiNo
        precio <- 0.90
    Fin Si
    total <- cantidad * precio
    Escribir "El total a pagar es ", total
FinAlgoritmo