Para consultar la api rest he desplegado un servidor, y la app cuenta con documentacion swagger,
el path del servidor es:

***************************************************************

http://190.124.144.225:8080/swagger-ui/index.html#/

***************************************************************

Para usar la api se debe entrar al enlace dado anteriormente una vez dentro se muestran los endpoint ordenados por swagger para probar alguno de ellos basta con hacer click en "Try out" en el caso de tratarse de un metodo GET sin PATH VARIABLE solo basta con ejecutar el boton EXECUTE para que muestre la respuesta del servidor.
En el resto de los casos se debe proporcionar tanto el ID del recurso afectado y o especificar en el body del request (el texto que aparece entre llaves) los datos con los que se quiera trabajar. teniendo en cuenta que sis se trata de una entidad compuesta por una o mas entidades (aparece mas de dos pares de llaves) se debe borrar las entidades de mayor de segundo nivel (las llaves que estan dentro de una llave que a su vez esta dentro de otra llave), dejando solamente la entidad principal y entre llaves especificando solamente el ID de la primera entidad que integra la entidad principal ademas de poner un "id": 1 (tener en cuenta borrar la coma final y probar con otros ID distintos y existentes en base de datos si se desea).

PROXIMAMENTE se le agregara un front-end para el proximo manejo de esta API por ahora solo esta pensado para se usado por un front-end developer.






# Documentación de la API REST

¡Bienvenido! Has desplegado un servidor con una API REST y documentación Swagger. Puedes explorar y probar los endpoints fácilmente accediendo a la [documentación Swagger](http://190.124.144.225:8080/swagger-ui/index.html#/).

## Cómo Usar la API

1. Ingresa al [enlace de Swagger](http://190.124.144.225:8080/swagger-ui/index.html#/).
2. Explora los endpoints organizados por Swagger.
3. Para probar un método GET, simplemente haz clic en "Try out" y luego en "Execute".
4. En otros métodos, proporciona el ID del recurso afectado y/o especifica datos en el cuerpo del request.
   - Si es una entidad compuesta, elimina las entidades de segundo nivel, dejando solo la entidad principal y especificando solo el ID de la primera entidad.
   - Ejemplo: `{ "id": 1, "nombre": "Ejemplo", ... }`.

## Importante

- **Proximamente:** Se añadirá un front-end para facilitar el manejo de esta API. Por ahora, está diseñada para ser utilizada por un front-end developer.

¡Gracias por utilizar nuestra API! Si tienes alguna pregunta o problema, no dudes en comunicarte con nosotros.