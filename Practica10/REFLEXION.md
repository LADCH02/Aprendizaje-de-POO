Preguntas de Reflexión

 

1. ¿Qué es una race condition? Describe un escenario concreto de tu código
   donde podría ocurrir.

    Una Condición de Carrera ocurre cuando dos o más hilos intentan acceder y modificar la misma variable al mismo tiempo, y el resultado final depende de qué hilo llegó una fracción de milisegundo antes.

    Escenario en el código: Si la fila de clientes no fuera synchronized, dos recepcionistas podrían ver que hay "4 clientes" (hay un lugar). Ambas intentarían insertar a un cliente en la posición 5 al mismo tiempo. Una de ellas sobrescribiría a la otra, provocando la pérdida de datos y que un cliente se "evapore" del sistema.
2. ¿Por qué =synchronized= resuelve el problema? ¿Qué desventaja de
   rendimiento tiene?

    Lo resuelve porque funciona como un "candado" en la puerta de un baño. Si el Hilo A entra al método sincronizado, pone el candado. Si el Hilo B llega, tiene que hacer fila fuera del método hasta que el Hilo A salga.

    Desventaja: Cuellos de botella y lentitud (Pérdida de rendimiento)

3. ¿Qué diferencia hay entre =Thread.sleep()= y =Object.wait()=? ¿Cuándo
   usarías cada uno?

    sleep(): Simplemente detiene el hilo por un tiempo definido (ej. 2 segundos). NO suelta el candado del objeto. Lo usaría para simular tiempos muertos, como lo usamos para el tiempo que toma limpiar una máquina.

    wait(): Detiene el hilo hasta que alguien más lo despierte con un notify(). Lo más importante es que SÍ suelta el candado del objeto para que otros hilos puedan usar el recurso compartido. Lo usaría cuando un hilo depende obligatoriamente del trabajo de otro (ej. un consumidor esperando a que un productor genere datos).