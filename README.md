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


Practica 5 -Polimorfismo

Patrón Template Method
En la clase abstracta Ejercicio, implementé el método concreto generarReporteEntrenamiento(). Este método es una implementación del patrón de diseño Template Method.

¿Qué hace este método?
Define el "esqueleto" o la estructura fija de cómo se debe mostrar la información de cualquier entrenamiento en la consola. Sigue un orden estricto de pasos:

Paso Concreto: Llama a resumen() (definido en la clase padre) para mostrar los datos generales.
Paso Abstracto: Llama a ejecutar(). Aquí es donde ocurre el polimorfismo, ya que la acción cambia dependiendo de si es un ejercicio de Cardio, Máquina o Peso Libre.
Paso de Interfaz: Llama a calcularCalorias(), forzando a que se muestre el cálculo específico de energía.
Paso Concreto: Llama a descansar() para cerrar el reporte con la técnica de recuperación.

¿Por qué lo diseñé así?
Lo diseñé con el modificador final para asegurar que el orden de los pasos sea inalterable. Aunque las clases hijas deciden "cómo" se ejecuta el ejercicio o "cuántas" calorías se queman, la clase padre decide "cuándo" y "en qué orden" se presenta esa información al usuario.

