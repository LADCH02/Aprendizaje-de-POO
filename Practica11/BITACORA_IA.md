PROMPT

Hola geminis me gustaria que me explicaras, como se realiza como se realizan los componentes perosnalizados en javafx, tambien como se maneja un evento de mouse y teclado y validacion de fomularios en tiempo real, me gustaria que todo me lo explicaras con un codigo para cada parte y aparte su respectiva toeria para cada concepto.

SALIDA

1. Componentes Personalizados en JavaFX
La Teoría:
En interfaces complejas, repetir el código para crear elementos similares (como tarjetas de perfil, paneles de estadísticas o filas de tablas personalizadas) ensucia el código. Un componente personalizado encapsula la vista (los nodos de JavaFX) y el comportamiento en una sola clase reutilizable.

Normalmente, esto se logra creando una clase que hereda de un contenedor existente (como VBox, HBox o StackPane) o de un control base, e inicializando sus elementos internos en el constructor.

El Código:
Imagina que necesitas mostrar una tarjeta con la información de un miembro. En lugar de crear un VBox y agregarle Labels cada vez, creamos el componente TarjetaMiembro.

Java
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// Heredamos de VBox para que nuestra tarjeta sea un contenedor vertical
public class TarjetaMiembro extends VBox {
    private Label lblNombre;
    private Label lblEstado;

    public TarjetaMiembro(String nombre, String estado) {
        // Configuramos el diseño del componente base (el VBox)
        this.setPadding(new Insets(10));
        this.setSpacing(5);
        this.setStyle("-fx-border-color: gray; -fx-border-radius: 5; -fx-background-color: #f9f9f9;");

        // Inicializamos los elementos internos
        lblNombre = new Label(nombre);
        lblNombre.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        lblEstado = new Label("Estado: " + estado);
        lblEstado.setStyle(estado.equals("Activo") ? "-fx-text-fill: green;" : "-fx-text-fill: red;");

        // Agregamos los elementos a nosotros mismos (al VBox)
        this.getChildren().addAll(lblNombre, lblEstado);
    }

    // Métodos para interactuar con el componente desde afuera
    public void actualizarEstado(String nuevoEstado) {
        lblEstado.setText("Estado: " + nuevoEstado);
        lblEstado.setStyle(nuevoEstado.equals("Activo") ? "-fx-text-fill: green;" : "-fx-text-fill: red;");
    }
}
2. Manejo de Eventos de Mouse y Teclado
La Teoría:
JavaFX utiliza una arquitectura impulsada por eventos (Event-Driven). Cualquier interacción del usuario (un clic, mover el mouse, presionar una tecla) genera un objeto Event. Puedes "escuchar" estos eventos asignando manejadores (EventHandlers) a tus nodos usando métodos de conveniencia como setOnMouseClicked o setOnKeyPressed.

Las expresiones Lambda de Java son la forma estándar y más limpia de manejar esto hoy en día.

El Código:
Vamos a darle interactividad a un botón y a capturar la tecla "Enter" en un campo de texto.

Java
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class PanelInteractividad extends VBox {

    public PanelInteractividad() {
        TextField campoBusqueda = new TextField();
        campoBusqueda.setPromptText("Buscar por matrícula y presionar Enter...");

        Button btnAccion = new Button("Registrar Entrada");

        // --- EVENTO DE TECLADO ---
        // Escuchamos cuando se presiona una tecla estando en el TextField
        campoBusqueda.setOnKeyPressed(evento -> {
            if (evento.getCode() == KeyCode.ENTER) {
                System.out.println("Buscando matrícula: " + campoBusqueda.getText());
                // Aquí podrías disparar un hilo para buscar en tu CSV/JSON
            }
        });

        // --- EVENTOS DE MOUSE ---
        // Efecto hover (cuando el mouse entra al área del botón)
        btnAccion.setOnMouseEntered(evento -> {
            btnAccion.setStyle("-fx-background-color: #a0d8ef; -fx-cursor: hand;");
        });

        // Efecto hover out (cuando el mouse sale)
        btnAccion.setOnMouseExited(evento -> {
            btnAccion.setStyle(""); // Vuelve al estilo por defecto
        });

        // Evento de clic
        btnAccion.setOnMouseClicked(evento -> {
            System.out.println("Clic registrado en coordenadas: X=" + evento.getX() + ", Y=" + evento.getY());
        });

        this.getChildren().addAll(campoBusqueda, btnAccion);
    }
}
3. Validación de Formularios en Tiempo Real
La Teoría:
La magia de la validación en tiempo real en JavaFX reside en las Properties (Propiedades Observables). Cada control en JavaFX expone sus estados a través de propiedades (ej. textProperty()). Puedes agregar un ChangeListener a estas propiedades para ejecutar código cada vez que el valor cambie, tecla por tecla.

Esto es vital para darle retroalimentación instantánea al usuario (por ejemplo, pintar el borde de rojo si ingresa letras en un campo de peso en kilogramos).

El Código:
Crearemos un campo para capturar un peso corporal objetivo que solo debe aceptar números y decimales, validándose instantáneamente.

Java
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FormularioValidado extends VBox {

    public FormularioValidado() {
        Label lblInstruccion = new Label("Ingresa el peso objetivo (kg):");
        TextField txtPeso = new TextField();
        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");

        // Agregamos el listener a la propiedad de texto
        txtPeso.textProperty().addListener((observable, valorAnterior, valorNuevo) -> {
            // Si el campo está vacío, limpiamos errores
            if (valorNuevo.isEmpty()) {
                txtPeso.setStyle("");
                lblError.setText("");
                return;
            }

            // Expresión regular: permite números enteros o con decimales (ej. 76 o 76.5)
            if (!valorNuevo.matches("\\d*(\\.\\d*)?")) {
                // Si el usuario teclea una letra, forzamos a que el texto vuelva a ser el anterior (bloqueo)
                txtPeso.setText(valorAnterior);
                lblError.setText("Solo se permiten números y puntos.");
                txtPeso.setStyle("-fx-border-color: red; -fx-focus-color: red;");
            } else {
                // Es un número válido (validación en tiempo real verde)
                txtPeso.setStyle("-fx-border-color: green; -fx-focus-color: green;");
                lblError.setText("");
            }
        });

        this.getChildren().addAll(lblInstruccion, txtPeso, lblError);
    }
}
Estos tres pilares te permitirán construir interfaces que no solo se ven bien, sino que se sienten profesionales e intuitivas de usar.


Considerando que estás implementando estructuras de datos complejas o múltiples hilos en el backend de tu software, ¿te gustaría que viéramos cómo conectar uno de estos eventos de botón para que actualice la interfaz gráfica usando Platform.runLater() mientras un hilo secundario procesa datos pesados de un archivo en el fondo?

2) PROMPT
si explicame.

SALIDA
La Teoría: El Hilo de la Interfaz Gráfica
JavaFX tiene una regla de oro inquebrantable: Toda la interfaz gráfica debe actualizarse exclusivamente desde el "JavaFX Application Thread" (el hilo principal de la UI).

Si pones a tu programa a leer un archivo masivo de registros en este hilo principal, la interfaz se "congelará" (el clásico mensaje de "El programa no responde") hasta que termine de leer el archivo, impidiendo que el usuario haga clic o mueva la ventana.

Para evitar esto, delegamos el trabajo pesado a un hilo secundario (Thread). Sin embargo, cuando ese hilo secundario termina su trabajo y quiere decirle a la pantalla "¡Ya terminé, muestra este texto verde!", no puede hacerlo directamente porque violaría la regla de oro. Aquí es donde entra Platform.runLater().

Platform.runLater(Runnable) toma tu actualización de la interfaz y la pone en una "cola de espera" segura para que el hilo principal de JavaFX la ejecute en cuanto tenga un milisegundo libre.

El Código: Hilos y Platform.runLater
Imagina un panel en tu sistema donde tienes un botón para cargar la base de datos de miembros desde un archivo CSV o binario. Queremos que la interfaz muestre "Cargando..." y que no se congele durante el proceso.

Java
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PanelCargaDatos extends VBox {

    private Label lblEstado;
    private Button btnCargar;
    private ProgressBar barraProgreso;

    public PanelCargaDatos() {
        this.setPadding(new Insets(20));
        this.setSpacing(10);

        lblEstado = new Label("Esperando acción...");
        btnCargar = new Button("Cargar Base de Datos");
        barraProgreso = new ProgressBar(0); // Inicia en 0%
        
        // Ocultamos la barra al inicio
        barraProgreso.setVisible(false);

        // --- MANEJO DEL EVENTO CON HILOS ---
        btnCargar.setOnAction(evento -> {
            
            // 1. Preparar la UI antes de la carga (Aún estamos en el hilo principal)
            lblEstado.setText("Procesando archivo, por favor espera...");
            btnCargar.setDisable(true); // Deshabilitamos el botón para evitar doble clic
            barraProgreso.setVisible(true);
            barraProgreso.setProgress(-1); // Modo indeterminado (animación de carga continua)

            // 2. Crear y arrancar el HILO SECUNDARIO para el trabajo pesado
            Thread hiloLectura = new Thread(() -> {
                
                // Aquí va la lógica pesada (lectura de CSV/JSON/Binario, red, etc.)
                // Simulamos una demora de 3 segundos con Thread.sleep()
                try {
                    Thread.sleep(3000); 
                    // Nota: ¡Nunca uses Thread.sleep() en el hilo principal!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Simulación de resultado de datos
                int registrosCargados = 150;

                // 3. ACTUALIZAR LA INTERFAZ GRÁFICA (Volver al hilo principal)
                // Envolvemos los cambios de UI en Platform.runLater
                Platform.runLater(() -> {
                    lblEstado.setText("¡Éxito! Se cargaron " + registrosCargados + " registros.");
                    lblEstado.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    btnCargar.setDisable(false); // Volvemos a habilitar el botón
                    barraProgreso.setVisible(false); // Ocultamos la barra
                });
                
            });

            // No olvides iniciar el hilo, o nada de lo anterior se ejecutará
            hiloLectura.start();
            
        });

        this.getChildren().addAll(lblEstado, barraProgreso, btnCargar);
    }
}
Puntos clave del ejemplo:
Aislamiento: El hilo principal reacciona al clic, actualiza la vista a "Cargando..." y lanza el hilo secundario. Inmediatamente queda libre, por lo que el usuario puede seguir moviendo la ventana de la aplicación.

Seguridad: El hilo secundario hace la "matemática y la lectura", pero nunca toca lblEstado ni btnCargar directamente.

Sincronización: Solo usamos Platform.runLater() al puro final de la tarea del hilo secundario, empaquetando únicamente las instrucciones visuales.

Aprendido:
Modularidad con Componentes Personalizados: Aprendimos que no se trata de apilar código espagueti en un solo archivo. Al crear clases que heredan de contenedores base (como VBox), encapsulamos el diseño y la lógica en piezas reutilizables. Esto es fundamental para estructurar aplicaciones multi-módulo (como un sistema de gestión de gimnasios) donde necesitas reciclar elementos como tarjetas de usuarios o paneles de control sin repetir código.

Interactividad a través de Eventos: Vimos cómo darle vida a la interfaz. Entendimos el modelo impulsado por eventos de JavaFX y cómo capturar acciones exactas del usuario (como presionar la tecla Enter o mover el mouse sobre un área específica) utilizando expresiones Lambda.

Prevención de Errores con Validación en Tiempo Real: Comprendimos el poder de las Properties en JavaFX. En lugar de validar un formulario completo hasta el final (cuando el usuario hace clic en "Guardar"), aprendimos a usar ChangeListeners para auditar y restringir la entrada de datos tecla por tecla, mejorando muchísimo la experiencia de usuario.