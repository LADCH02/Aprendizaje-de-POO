Preguntas de Reflexión

 

1. ¿Por qué marcamos atributos como =private=? ¿Qué riesgo evitamos?
Bueno evitamos que los datos sean modificados con esto le damos cierta seguridad, solo puedes agregar
datos mediante los metodos creados en la clase.

2. ¿Cuál es la diferencia entre =private=, =protected= y =public=? Ilustra
   con un ejemplo de tu código.
Private: Es una forma de mantener los datos mas seguros desde, solo pueden accceder desde el mismo codigo declarado dentro de la misma clase.
Protected: Accesible dentro del mismo paquete y subclases.
Public: Es posible acceder desde cualquier clase, ya sea en el mismo paquete o fuera de el.

3. ¿Qué validación incluiste en un setter? ¿Qué pasa si el valor recibido
   es inválido?
Bueno inclui dos validaciones una para el peso y otra para el nombre, que no se pudiera pesos menores a 1 y mayores a 300, si el valor recibido no es valido 
lo que pasa es que se asigna un valor null o 0 dependiendo del tipo de dato.
