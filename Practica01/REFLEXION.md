Preguntas de reflexion

1. ¿Qué diferencia hay entre JDK, JRE y JVM? ¿Por qué instalamos el JDK?
JVM -- tiene como tarea leer el codigo ya coplilado y traducirlo a instrucciones que el procesador de tu computadora entienda
JRE -- Es el paquete que necesitas para ejecutar prgramas de java.
JDK -- Incluye el jre, pero anade herramientas de desarrollo, generador de dcumentacion y depuradores.

Respecto a al por que necesitamos el JDK es debido a que necesitamos el compilador, sin el no podemos trasformar el codigo que 
escribimos en un archivo .java

2. ¿Por qué Java es considerado «write once, run anywhere»? Explica con tus
   propias palabras.
Hace referencia a que java puede ser correr en cualquier dispositivo que tenga instalado el JVM, debido a que java creo el bytecode 
Cuando termina el codigo, el complilador genera un archivo intermedio que no es esclusivo de ningun sistema operativo. 

3. ¿Qué hace exactamente =System.out.println()=? ¿Qué clase y método estás
   usando?
Es una instruccion basico en java para mostrar datos en pantalla.

System - es la clase que viene en el paquete, permitiendo acceso a recursos del sistema, como la entrada, salida y errores.

out - Es un atributo, que representa el flujo de salida, es una instancia de la clase PrintStream.

println() - El metodo  que pertenece al obejeto out

