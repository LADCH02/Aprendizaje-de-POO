1. ¿Cuándo preferirías una clase abstracta sobre una interfaz? ¿Y al revés?
   - Bueno en el caso de la clase abtracta, puedo entenderlo de la forma en que cuando tienes alguna base que se puede herdar a tus siguiente base 
   se hereda, veamoslo de otra forma un padre siempre va querer que sus hijos no comentan sus erroes para eso el ya los cometio y el hijo lo sabe 
   por ende ya no la va hacer, pero lo puede hacer, en otras palabras nos ayuda a no reptir codigo.
   - Ahora bien la interfaz, de manera sencilla cuando ciertas clases observas que pueden tener una funcionalidad similar se crean, no ves las jerarquias de herencia, lo que tienes que ver es que hace el objeto


2. ¿Una clase puede implementar varias interfaces? ¿Por qué Java permite
   eso pero no herencia múltiple de clases?
   Si se puede implemantar varias interfaces como pudimos observar en el programa se implemento dos interfaces en la clase crosffit

   Bueno se puede implementar debido a que la clase que las implementa es la que rige la logica como tal.

   En herencia paso algo interesente, tengo entendido que es por el echo que aqui pasa al reves
   la logica la rige las clases superiores, entonces tomando en cuenta este concepto puede llegar un punto 
   en que ciertas logicas choquen.

3. Si agregas un método nuevo a una de tus interfaces, ¿qué clases se ven
   afectadas? ¿Cómo lo resolverías con un método =default=?
   Se verian afectadas todas las clases en las que implemente la interfaz, no podrias copilar
   hasta que agregue el nuevo metodo en dichas clases


   Bueno default sirve mas que nada para poder implementar logica dentro de tu interfaz
   y que no sean vacias, de este modo la clase donde implementes la interfaz ya no te pedira
   que escribas el metodo, pero tambien puedes escribir si tu quieres dentro de la clase la logica
   que deseas usar.