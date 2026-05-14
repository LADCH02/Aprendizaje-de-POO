Estrategias de Sincronización Implementadas

Para implementar el patrón Productor-Consumidor de manera segura:

1. synchronized: Aplicado en los métodos agregarCliente y atenderCliente de la clase ZonaEspera. Asegura exclusión mutua; es decir, garantiza que si un hilo está modificando la fila (Lista), ningún otro hilo puede leerla o modificarla al mismo tiempo, previniendo errores de memoria.
2. wait(): Si un entrenador entra a atenderCliente y nota que la lista está vacía, llama a wait(). Esto duerme al hilo y libera el candado (lock) para que la recepción pueda agregar a alguien.
3. notifyAll(): Cuando la recepción finalmente agrega a un cliente, llama a notifyAll() para despertar a todos los entrenadores dormidos y avisarles: "¡Ya hay clientes, a trabajar!".