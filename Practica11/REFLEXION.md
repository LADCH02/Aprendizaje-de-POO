 Preguntas de Reflexión

 

1. ¿Qué es el hilo de la UI (JavaFX Application Thread) y por qué no debes
   hacer operaciones pesadas en él?
Es un hilo principal y exclusivo encargado de ponener los elementos visuales,
tambien de recibir interraciones.
Bueno no se le deberia de poner tareas pesadas debido a que si lo haces se puede 
congelar la ventana y posiblemente aparecera el programa no responde.

2. ¿Qué es un =EventHandler=? ¿Cómo conecta la acción del usuario con la
   lógica de tu programa?

Un EventHandler es un "escuchador" de eventos. Es un objeto que se mantiene a la espera de que ocurra una acción física en la interfaz.
Actúa como el puente de comunicación: cuando el usuario realiza una acción física (como hacer clic en el botón "Eliminar Seleccionado"),
 el sistema operativo emite una señal. El EventHandler captura esa señal específica y, como respuesta, ejecuta inmediatamente el bloque 
 de código lógico en Java que tú le asignaste (por ejemplo, remover el objeto de la lista y borrarlo del sistema). En nuestro código, lo implementamos usando expresiones Lambda (e -> { ... }).
3. ¿Qué diferencia hay entre un =Stage=, una =Scene= y un =Node= en JavaFX?

Stage (El Escenario): Es el contenedor de más alto nivel. Es la ventana física de tu computadora (el marco del sistema operativo que tiene los botones de minimizar,
 maximizar, cerrar y el título de la aplicación).

Scene (La Escena): Es el lienzo o el contenido que se monta sobre el escenario. Puedes tener múltiples escenas e intercambiarlas en el mismo Stage
 (por ejemplo, quitar la escena del Menú Principal para poner la escena del Inventario).

Node (Los Nodos): Son los "actores" y la utilería. Absolutamente cualquier componente visual que pongas dentro de tu Scene es un Nodo 
los botones Button, las etiquetas Label, los campos de texto TextField, las tablas, etc