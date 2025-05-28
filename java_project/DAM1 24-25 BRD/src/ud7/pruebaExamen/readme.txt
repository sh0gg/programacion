===============================================
Ejercicio 1: Notas y Promedios
===============================================

Objetivo:
---------
Desarrollar un programa en Java que lea un fichero de texto con nombres de estudiantes y sus calificaciones,
calcule el promedio de cada estudiante y escriba los resultados en un nuevo fichero de texto.

Solución:
---------
- Se implementó la clase AppNotas.java en el paquete "notas".
- El programa lee el fichero "notas.txt", donde cada línea tiene el formato: Nombre,nota1,nota2,...
- Para cada línea, se separan el nombre y las notas, se calculan los promedios y se guardan en "promedios.txt".
- Se maneja el caso en que el fichero no exista, esté vacío o tenga líneas con formato incorrecto, mostrando mensajes adecuados.
- El programa es robusto ante errores de formato, evitando que se detenga abruptamente.

Aspectos importantes:
---------------------
- Uso de BufferedReader y BufferedWriter para lectura y escritura eficiente.
- Separación y parseo de datos mediante split y manejo de excepciones NumberFormatException.
- Validación de datos antes de procesar para asegurar integridad.


===============================================
Ejercicio 2: Inventario de Productos
===============================================

Objetivo:
---------
Crear una aplicación en Java que gestione un inventario de productos utilizando ficheros binarios para almacenamiento,
permitiendo agregar productos, listar todos y buscar por código.

Solución:
---------
- Se creó la clase Producto.java que implementa Serializable y tiene atributos: código, nombre, cantidad y precio.
- La clase AppInventario.java gestiona el inventario desde consola:
  * Agregar producto solo si el código no existe y el nombre no está vacío.
  * Listar productos ordenados por código.
  * Buscar producto por código y mostrar información.
- Se implementó serialización y deserialización para guardar y leer objetos Producto en el fichero "inventario.dat".
- Manejo de excepciones para controlar errores de E/S y formatos inválidos.

Aspectos importantes:
---------------------
- Uso de ObjectInputStream y ObjectOutputStream para manejo de objetos en ficheros binarios.
- Carga y guardado completo de la lista de productos para evitar problemas con cabeceras en ficheros binarios.
- Validaciones para evitar duplicados y datos inválidos.

===============================================
Ejercicio 3: Interfaces Gráficas con JavaFX
===============================================

Objetivo:
---------
Crear versiones gráficas de los ejercicios anteriores usando JavaFX para mejorar la interacción y usabilidad.

Solución:
---------
- AppNotasFX.java: Lee notas.txt, calcula promedios y muestra resultados en una ventana con TextArea y botón para calcular,
  además de guardar el fichero promedios.txt.
- AppInventarioFX.java: Interfaz gráfica para gestionar inventario con:
  * Campos de texto para ingresar nuevo producto.
  * Botones para agregar producto y buscar por código.
  * ListView para listar productos cargados.
  * Área de texto para mostrar mensajes y resultados.
- Se maneja la carga y guardado de productos en inventario.dat con serialización.
- Se validan entradas y se muestran mensajes claros al usuario.

Aspectos importantes:
---------------------
- Uso de controles JavaFX como TextField, Button, ListView, TextArea y layouts como VBox, GridPane y HBox.
- Manejo de eventos con setOnAction para interacción del usuario.
- Uso de ObservableList para actualizar automáticamente la lista mostrada.
- Manejo de excepciones y mensajes de error en interfaz gráfica para mejor experiencia.

--------------------------------------------------------
Este proyecto demuestra conocimientos de:
- Manejo de ficheros de texto y binarios en Java.
- Uso de serialización para objetos complejos.
- Programación orientada a objetos y buenas prácticas.
- Creación de interfaces gráficas con JavaFX.
- Manejo adecuado de excepciones para robustez.

Autor: [Tu Nombre Completo]
Fecha: [Fecha de realización]
