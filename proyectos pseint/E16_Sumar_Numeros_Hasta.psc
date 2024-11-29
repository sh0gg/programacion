Algoritmo E16_Sumar_Numeros_Hasta
    suma = 0
    Repetir
        Escribir "Introduce un número (cero o negativo para terminar): "
        Leer numero
        Si numero > 0 Entonces
            suma = suma + numero
        Fin Si
    Hasta Que numero <= 0
    Escribir "La suma total es ", suma
FinAlgoritmo
