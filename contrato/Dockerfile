# Usar imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del proyecto al contenedor
COPY target/contrato-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8001
EXPOSE 8003

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]