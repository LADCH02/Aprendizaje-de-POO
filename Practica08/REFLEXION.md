
1. ¿Por qué usaste cada estructura de colección para cada tipo de dato?

   ¿Qué pasaría si usaras =ArrayList= para todo?

Bueno utilice una estructura de coleccion para cada tipo de dato debido a que cada coleccion 
resuelve un algo, en pocas palabras no existe como tal un coleccion perfecta

Ejemplo:
ArrayList: en este caso es muy bueno para mantener el orden en el que se inserto.
HashSet: Bueno principalmente lo mas beneficioso para nosotros es que no se puede
introducir un duplicado.
HashMap: Permite un busqueda mas eficiente, pues trabaja con clave y valor
Queue: Funciona como un cola tradicional en palabras simples.

Si todo estuviera en un ArrayList, lo que pasaria seria que tuvieramos una busqueda 
mas lenta, tambien tendriamos un procedimiento mas lento de insercion, en pocas palabras
al tomar una coleccion unica aumentarimos el cosumo de recursos debido a que como tal si se puede 
lograr hacer las operaciones pero mucho mas lentas.

2. ¿Qué diferencia hay entre =Comparable= y =Comparator=? ¿Cuándo usarías

   cada uno?
Bueno primero tenemos que entenderlo como algunos temas pasados, comparator funciona como 
tener muchos metodos, pues pudes tener infinitos criterios de ordenamiento y en cambio Comparable
se implementa en la clase como tal y esto permite tener un criterio de ordenamiento.

cuando usarlas bueno comparable cuando sea algo que no sea algo tan comlejo de otra forma
seria ordenamientos obvios y en cambio comparator es cuando te das cuenta que se necesita 
varios filtrados.

3. Explica con tus palabras qué hace una operación Stream. ¿Por qué es más

   legible que un bucle =for=?

Pues de cierta foma se podria decir que es como estaciones al hablar de stream debido a que
cada estacion va recolectando informacion y al final de todo obten el resultado.

Bueno el por que es mas legible que un ciclo for yo diria que es debido a que mas lenguaje humano
y se puede interpretar mas facil.
