Funcion maximo <- max(a, b)
    Si a > b Entonces
        maximo <- a
    SiNo
        maximo <- b
    Fin Si
Fin Funcion

Algoritmo E18_Maximo
    Escribir "Introduce dos números:"
    Leer num1, num2
    Escribir "El máximo es ", max(num1, num2)
FinAlgoritmo
