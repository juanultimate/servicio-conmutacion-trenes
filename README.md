# Servicio Conmutación de Trenes

El servicio local de conmutación de trenes sirve en varias ciudades en Kiwiland. Por razones financieras, todas las rutas tienen un solo sentido. Eso es, una ruta desde Kaitaia a Invercargill no implica la existencia de una ruta desde Invercargill a Kaitaia. En efecto, a pesar de que las dos rutas existan, son distintas y pueden ser de distancias diferentes.

### Ingreso de datos
Un grafo direccionado, donde un nodo representa una ciudad y una arista representa una ruta entre dos ciudades.  La ponderación de la arista representa la distancia entre las dos ciudades. Ninguna ruta aparecerá más de una vez, y para una ruta definida, el origen y el destino no puede ser la misma ciudad.
Para el aplicativo la entrada de datos es un archivo TXT en el cuál la primera linea debe ser la definición del grafo y las posteriores serán preguntas con un formato específico predeterminado. A continuación se muestra un ejemplo del contenido del archivo TXT de ingreso de datos.
```
The distance of the route A-B-C
The distance of the route A-D
The distance of the route A-D-C
The distance of the route A-E-B-C-D
The distance of the route A-E-D
The number of trips starting at C and ending at C with a maximum of 3 stops
The number of trips starting at A and ending at C with exactly 4 stops
The length of the shortest route (in terms of distance to travel) from A to C
The length of the shortest route (in terms of distance to travel) from B to B
The number of different routes from C to C with a distance of less than 30
```

### Salida de datos
Al obtener la distancia de una ruta, en caso de que dicha ruta no exista, la salida debe ser: ‘NO SUCH ROUTE’.  Caso contrario, se debe seguir la ruta sin paradas adicionales!. Por ejemplo para la ruta A-B-C (item 1), donde la distancia entre A y B es 5 y la distancia entre B y C es 4, la salida esperada es 9.

La presentación de los resultados será en consola. Por ejemplo para las preguntas anteriores la presentación de los resultados sería la siguiente:
```
9
5
13
22
NO SUCH ROUTE
2
3
9
9
7
```
### Descripción de la solución.
##### Conceptual
Para la solución se ha hecho uso de la Teoría de Grafos, específicamente [Grafos Dirigidos] para la [representación del problema].
Además se ha usado el algoritmo [Búsqueda en profundidad] para la búsqueda de caminos.

##### Técnica.
Para la solución se ha usado el Lenguaje de Programación JAVA.
A continuación se describe brevemente los paquetes creados:

```ec.edu.juanultimate.conmutadortrenes.app```:Contiene la clase que ejecuta la  aplicación.

```ec.edu.juanultimate.conmutadortrenes.excepcion```: Contiene las excepciones de la aplicación.

```ec.edu.juanultimate.conmutadortrenes.filtros```: Contiene filtros par la búsqueda de rutas entre ciudades. Existe un filtro para cada criterio de búsqueda identificado en el ingreso de los datos.

```ec.edu.juanultimate.conmutadortrenes.grafos```: Contiene el modelamiento de la solución mediante el uso de grafos. Dentro existen clases como ```Grafo```, ```Arista```, ```Vertice```, ```GrafoDirigido```.

```ec.edu.juanultimate.conmutadortrenes.ingreso```: Contiene clases que representan instrucciones a ejecutarse. Estas instrucciones se las construye de acuerdo a las entradas del usuario en el archivo de texto. Existen instrucciones para construir el grafo (Red Vial), buscar distancia más corta, buscar posibles caminos, etc.

```ec.edu.juanultimate.conmutadortrenes.servicio```: Contiene una representación del commutador de trenes de Kiwiland. Esta representación es como una fachada que se apoya de los demas componentes y los engrana para así concentrar todas las posibles opciones de procesamiento de la aplicación.

### Puesta en marcha
##### Requisitos
Para la ejecución del programa se requiere [Java 8] y [Gradle] v2.6 o superior*.


```
*Si posee una versión anterior de Gradle se recomienda usar una versión Wrapper del mismo el cual ya se encuentra preconfigurada. Para mayor información visitar: https://docs.gradle.org/current/userguide/gradle_wrapper.html
```



##### Ejecución
Para la ejecución se debe ejecutar siguiente procedimiento.

1. Ubicarse sobre la raiz del proyecto. *[RAIZ_PROYECTO]*

2. Abrir el archivo: *[RAIZ_PROYECTO]/src/main/resources/datos.txt*

3. Ingresar los datos de ingreso.

4. Volver a *[RAIZ_PROYECTO]*

5. Ejecutar el comando:
    ```sh
    $ gradle clean run
    ```

### Librerías usadas
1.  Junit
2.  Hamcrest
3.  Mockito




### Version
1.0-SNAPSHOT



   [Búsqueda en profundidad]: <https://es.wikipedia.org/wiki/B%C3%BAsqueda_en_profundidad>

   [Grafos dirigidos]: <http://algorithmics.lsi.upc.edu/docs/ada/MTA/grafos.pdf>
   [representación del problema]: <https://www.uam.es/personal_pdi/ciencias/gallardo/capi9-grafos-0910.pdf>
   [Java 8]:<http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>
   [Gradle]: <http://gradle.org/>



