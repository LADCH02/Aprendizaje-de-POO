# Aprendizaje-de-POO
Realizaremos un total de 11 programas de aprendizaje para practicar las habilidades de POO


Práctica 1 — Introducción a Java y Configuración del Entorno

El proceso de instalacion de jdk fue sencillo solo tuve que buscar una version reciente que se adapatara a mis intereses, elegi oracle 
luego de eso me pase a escoger el entorno donde empezaria a trabajar con mi codigo en este caso escogi el apache debido a que me lo recomendaron
en muchas resenas que alcance a leer.

Realice el programa de de conversion de unidades debido a que me llamon la atencion como seria ver un programa que venimos haciendo en c y c++ en java con esto puedo 
conluir que el programa mantiene una logica similar solo cambia ciertas cosas de sintaxis a la ahora de emplear lo basico que es imprimir,
obteneter informacion de entrada.


Práctica 2 — Clases y Objetos en Java
En este proyecto el dominio que escogi fue Ejercicio debido que me parece una forma muy buena de abordar el tema, ejercicio tiene muchas cosas faciles de abtraer para poder comprender mejor el concepto de clase y objetos. Tambien es un tema que me interesa mucho en particular el gym.



Práctica 3 — Encapsulamiento y Modificadores de Acceso
Bueno esta practica agregamos 2 condiciones muy importantes a mi parecer.
1) peso < 0 y peso > 300 debido a que no se puede realizar un ejercicio con peso 0 y al mismo tiempo en este gym no contamos con pesos mayores a 300
2)  Nombre mayor a 2 letras debido a que un nombre de 3 letras es muy pequeño y puede llegar a ser fradualento en mexico.

Práctica 4 — Herencia

1. Justificación del Dominio
Se eligió el dominio de Entrenamiento Físico porque permite modelar una jerarquía natural. La herencia tiene sentido aquí porque todos los ejercicios comparten una base (nombre, grupo muscular), pero su ejecución y métricas (peso vs. distancia) varían. La herencia permite tratar diversos ejercicios de forma uniforme en una rutina.

2. Estructura de la Jerarquía (3 Niveles)
Nivel 1 (Padre): Ejercicio (Abstracta). Define la base universal y el contrato ejecutar().

Nivel 2 (Intermedia): EjercicioFuerza (Abstracta). Añade atributos de carga (pesoKg, rpe) exclusivos de pesas.

Nivel 3 (Concretas): * PesoLibre: Implementa ejecución con mancuernas/barras.

Maquina: Añade numeroMaquina y ejecución guiada.

Cardio: Hereda de Ejercicio, enfocada en distanciaKm.

3. Problema de Diseño Identificado
Situación: Inicialmente, el atributo pesoKg estaba en la clase padre Ejercicio.
Conflicto: Al crear Cardio, esta heredaba un atributo de peso innecesario, generando objetos con "datos basura".
Solución: Se aplicó una refactorización creando la clase intermedia EjercicioFuerza. Así, Cardio solo hereda lo esencial, manteniendo la integridad del diseño y evitando la "herencia forzada".
