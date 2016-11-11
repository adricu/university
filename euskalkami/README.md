EusKalKami (2014)


DESCRIPCIÓN:


El proyecto está basado en dos apps: una web escrita en python y alojada en el Google App Engine que es el que trata las peticiones POST que se realizan en aplicación móvil (Android).


Se realizan dos peticiones: una para ver la cantidad de producto que existe en el momento que se entra a detalles de producto (Máximo: x) y otra para efectuar la transacción y guardarla en una BD en el servidor. Hay ejemplos en capturas de imagen de como es guardada esta información.
Una vez se entra a la descripción del producto y se realizan la petición para saber el máximo de producto que hay, este máximo se queda guardado (aún sin conexión a internet) para el resto de sesión en la aplicación hasta que se actualice (al entrar de nuevo con conexión a la descripción del producto).


FUNCIONALIDADES:

La aplicación Android tiene dos funcionalidades: por una parte la de efectuar pedidos (después de añadirlos al carrito) y otra de geolocalización que nos muestra donde nos está situada la tienda de la empresa.


VERSION ANDROID:


Se adjunta en esta carpeta el código de la aplicación y la apk para instalar en el dispositivo. 
La versión mínima que acepta es la API 11 de Android.
