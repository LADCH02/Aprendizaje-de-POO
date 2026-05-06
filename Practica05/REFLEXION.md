Preguntas de Reflexión
 
1. ¿Qué diferencia hay entre sobrescritura (override) y sobrecarga
   (overload)? Da un ejemplo de cada una desde tu código.
   overload: tiene varios metodos en la clase con el mismo nombre es una de las 
   formas de java que podemos aprovechar para solucinar varios problmeas.
   override: Es cuando una clase hija propone su propio implementacion dado que ya existe 
   en la clase padre o en una interfaz.
   Ejemplo:
   En la clase ejercicio tenemos el metodo ejecutar y en clase hhija maquina se utilizo
   override para sobrescribirlo y darle un comportamiento especifico.

2. ¿Por qué usaste =instanceof= antes de hacer un cast? ¿Qué excepción
   previene?
   Bueno en este caso instanceof actua como una validacion pregunta a ver ese objeto
   realmente es una maquina, de esta forma nos evitamos un problema de excepción
   pues estariamos forzando a un objeto que no es maquina actuar como tal.

3. ¿Podrías instanciar tu clase abstracta directamente? ¿Por qué sí o por
   qué no?
   Bueno cuando tienes una clase abstracta ya no se puede instanciar debido a que 
   es parte de la abstraccion, pero esto mismo nos ayuda a que podamos instaciar 
   a sus clases hijas. de otra forma seria como decir que la clase abstracta es
   un molde.

