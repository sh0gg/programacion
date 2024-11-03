Algoritmo E10_LangostaAfumada
    Escribir "Introduce el número de personas:"
    Leer personas
    Si personas > 300 Entonces
        costo_por_persona <- 75
    SiNo
        Si personas > 200 Entonces
            costo_por_persona <- 85
        SiNo
            costo_por_persona <- 95
        Fin Si
    Fin Si
    total <- personas * costo_por_persona
    Escribir "El presupuesto total es ", total
FinAlgoritmo
