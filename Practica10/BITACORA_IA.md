Prompt 
1) Quiero que me expliques a detalle como funciona Thread y runnable, con ejemplos de codigo y tambien como ralizar sincronizacion y axcede a recursos compartidos , 2) como implementar productor y cosumidor con buffer compartido y multipliles productos, tambien con ejemplo de codigo. 3) Uso de =ExecutorService= con un pool de hilos y tambien con ejemplo de codigo.

4.) Demostración de =synchronized=, =wait()= y =notify() y que seas especifco para lograr entender mejor esto .


Salida del Prompt

Hola! Dominar la concurrencia en Java es uno de los mayores saltos que puedes dar como desarrollador. Es un tema complejo porque los humanos pensamos de forma secuencial (una cosa a la vez), pero las computadoras pueden hacer malabares con múltiples tareas al mismo tiempo.Vamos a desglosar esto paso a paso, con analogías claras y código directo.1. Thread vs Runnable y Acceso a Recursos CompartidosPara ejecutar tareas en paralelo en Java, necesitas "Hilos" (Threads). Hay dos formas principales de crearlos:Extender la clase Thread: No recomendado, ya que Java no permite herencia múltiple. Si extiendes Thread, tu clase no podrá heredar de ninguna otra.Implementar la interfaz Runnable: Es la mejor práctica. Defines la tarea (el qué) separada del hilo que la ejecuta (el quién).Ejemplo Básico: Creación y EjecuciónJava// 1. Definimos la tarea implementando Runnable
class MiTarea implements Runnable {
    private String nombre;

    public MiTarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando " + nombre + " en el hilo: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Creamos la tarea
        MiTarea tarea = new MiTarea("Tarea 1");
        
        // 3. Se la pasamos a un Thread y lo iniciamos
        Thread hilo = new Thread(tarea);
        hilo.start(); // Ojo: usar start(), NO run()
    }
}
El Problema de los Recursos Compartidos (Condición de Carrera)Si dos hilos intentan modificar la misma variable al mismo tiempo, los datos se corrompen. Imagina a dos personas intentando actualizar el mismo documento de Excel al mismo milisegundo: los cambios se sobrescriben. Para evitarlo, usamos la sincronización.4. Demostración de synchronized, wait() y notify()Antes de ver el Productor-Consumidor, necesitas entender estas tres palabras mágicas. Piensa en un objeto de Java como una habitación con una sola llave (el monitor o lock).synchronized: Es la regla que dice "Para entrar a este método, necesitas la llave de la habitación". Si un hilo entra, se guarda la llave en el bolsillo. Los demás hilos que intenten entrar chocarán con la puerta cerrada y esperarán afuera.wait(): Un hilo dice: "Tengo la llave, pero me falta algo para continuar (ej. no hay datos). Dejaré la llave en la mesa, me iré a dormir en la esquina de la habitación, y dejaré que otro entre".notify() / notifyAll(): Un hilo dice: "¡He cambiado algo en la habitación! Despierten a los que estaban durmiendo (esperando) para que intenten tomar la llave de nuevo".2. Patrón Productor y Consumidor (con Buffer Compartido)Este es el ejemplo clásico para usar wait() y notifyAll().Productor: Crea datos y los pone en una caja (Buffer). Si la caja está llena, espera (wait).Consumidor: Saca datos de la caja. Si la caja está vacía, espera (wait).El Buffer Compartido (La Habitación con Llave)Javaimport java.util.LinkedList;
import java.util.Queue;

class BufferCompartido {
    private Queue<Integer> cola = new LinkedList<>();
    private int capacidad;

    public BufferCompartido(int capacidad) {
        this.capacidad = capacidad;
    }

    // Método sincronizado: solo un hilo puede producir a la vez
    public synchronized void producir(int valor) throws InterruptedException {
        // Usamos 'while' y no 'if' para evitar falsos despertares
        while (cola.size() == capacidad) {
            System.out.println("📦 Buffer LLENO. Productor esperando...");
            wait(); // Suelta la llave y se duerme
        }
        
        cola.add(valor);
        System.out.println("✅ Producido: " + valor);
        
        // Avisa a los consumidores dormidos que ya hay algo que consumir
        notifyAll(); 
    }

    // Método sincronizado: solo un hilo puede consumir a la vez
    public synchronized int consumir() throws InterruptedException {
        while (cola.isEmpty()) {
            System.out.println("📭 Buffer VACÍO. Consumidor esperando...");
            wait(); // Suelta la llave y se duerme
        }
        
        int valor = cola.poll();
        System.out.println("🍽️ Consumido: " + valor);
        
        // Avisa a los productores dormidos que ya hay espacio en el buffer
        notifyAll(); 
        
        return valor;
    }
}
Los Hilos y el MainJavaclass Productor implements Runnable {
    private BufferCompartido buffer;

    public Productor(BufferCompartido buffer) { this.buffer = buffer; }

    public void run() {
        int i = 0;
        try {
            while (true) {
                buffer.producir(i++);
                Thread.sleep(500); // Simula tiempo de producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumidor implements Runnable {
    private BufferCompartido buffer;

    public Consumidor(BufferCompartido buffer) { this.buffer = buffer; }

    public void run() {
        try {
            while (true) {
                buffer.consumir();
                Thread.sleep(1000); // El consumidor es más lento que el productor
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MainConcurrencia {
    public static void main(String[] args) {
        BufferCompartido buffer = new BufferCompartido(3); // Capacidad máxima de 3

        // Múltiples productores y consumidores
        Thread p1 = new Thread(new Productor(buffer), "Productor-1");
        Thread p2 = new Thread(new Productor(buffer), "Productor-2");
        Thread c1 = new Thread(new Consumidor(buffer), "Consumidor-1");

        p1.start();
        p2.start();
        c1.start();
    }
}
En este código, como hay dos productores rápidos y un consumidor lento, verás cómo el buffer se llena rápidamente y los productores se ven obligados a hacer wait() hasta que el consumidor libere espacio.Para que puedas visualizar este flujo dinámico entre capacidad, espera y procesamiento, aquí tienes una simulación interactiva:3. Uso de ExecutorService con un Pool de HilosCrear y destruir hilos con new Thread().start() es "caro" para el sistema operativo en términos de memoria y CPU. En aplicaciones reales, usamos un Thread Pool (Piscina de hilos) gestionado por un ExecutorService.¿Cómo funciona? Creas, por ejemplo, 5 hilos fijos. Si les envías 100 tareas, los 5 hilos tomarán las 5 primeras. Conforme terminan, reciclan el hilo y toman la siguiente tarea de la cola automáticamente.Ejemplo de Código:Javaimport java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TareaEmail implements Runnable {
    private int idCliente;

    public TareaEmail(int idCliente) { this.idCliente = idCliente; }

    @Override
    public void run() {
        System.out.println("📧 Enviando email a cliente " + idCliente + " | Hilo: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulamos que el envío tarda 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class EjemploThreadPool {
    public static void main(String[] args) {
        // Creamos un pool de exactamente 3 hilos reciclables
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Iniciando envío masivo de correos...");

        // Mandamos 10 tareas al executor
        for (int i = 1; i <= 10; i++) {
            executor.execute(new TareaEmail(i));
        }

        // Es vital apagar el executor para que el programa pueda terminar.
        // shutdown() le dice: "No aceptes más tareas, pero termina las que ya te di".
        executor.shutdown();
        
        System.out.println("Todas las tareas fueron enviadas al executor.");
    }
}


Aprendido:

De esto se aprendio que  como relizar que solo un hilo pueda acceder a un recurso compartido utilizando synchronized, wait() y notify() para manejar la sincronización entre hilos. Además, se mostró cómo implementar el patrón productor-consumidor con un buffer compartido y cómo usar ExecutorService para gestionar un pool de hilos de manera eficiente.
tamibien como crear hilos en Java utilizando la interfaz Runnable y la clase Thread, y cómo manejar la concurrencia para evitar condiciones de carrera al acceder a recursos compartidos.