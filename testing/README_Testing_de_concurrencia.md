# Ejemplo de Prueba de Concurrencia en Java

Este proyecto de ejemplo demuestra cómo realizar pruebas de concurrencia en Java utilizando JUnit y el paquete `java.util.concurrent`. El código incluye un test que ejecuta tres tareas concurrentes y espera a que todas terminen antes de realizar aserciones.

## Requisitos

- **Java:** Asegúrate de tener Java instalado en tu máquina. Puedes descargarlo desde [java.com](https://www.java.com/es/download/).

## Instrucciones de Ejecución

1. **Descarga el Código:**
   - Clona este repositorio o descarga el código como un archivo ZIP.

2. **Compila el Código:**
   - Abre una terminal y navega al directorio del proyecto.
   - Ejecuta el siguiente comando para compilar el código:
     ```bash
     javac TestConcurrencia.java TareaConcurrente.java
     ```

3. **Ejecuta las Pruebas:**
   - Ejecuta el siguiente comando para ejecutar las pruebas:
     ```bash
     java -cp .:junit-4.x.jar:hamcrest-core-x.x.jar org.junit.runner.JUnitCore TestConcurrencia
     ```
     Asegúrate de reemplazar "4.x" con la versión de JUnit que estás utilizando y "x.x" con la versión de Hamcrest que estás utilizando.

4. **Observa la Salida:**
   - Observa la salida en la consola para verificar que las tareas se ejecutan concurrentemente y que las aserciones pasan con éxito.

5. **Personaliza el Código (Opcional):**
   - Siéntete libre de personalizar el código según tus necesidades y experimentar con diferentes configuraciones de concurrencia.

¡Listo! Has ejecutado con éxito las pruebas de concurrencia en Java.
