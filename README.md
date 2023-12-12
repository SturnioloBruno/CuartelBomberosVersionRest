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

¡Gracias por utilizar nuestra API! Si tienes alguna pregunta o problema, no dudes en comunicarte conmigo a este correo brunosebastian.sturniolo@gmail.com .