Practica 7

He implementado una jerarquia de excepciones encabezada por GymException.

**Informacion de Contexto Adicional:**
La clase PesoInvalidoException incluye el atributo valorErroneo (double) y GymException incluye un time (LocalDateTime).

**Justificacion:**
En un sistema real, simplemente recibir un mensaje de "Peso invalido" no es suficiente para el equipo de soporte tecnico. Al incluir el **valor exacto** que causo el error y la **hora precisa**, podemos:

1. Identificar si el error fue un dedo mal puesto del usuario (ej. escribio -50 en lugar de 50).
2. Rastrear patrones de error en horarios especificos.
3. Facilitar la depuracion (debugging) sin tener que recrear manualmente el escenario del usuario.