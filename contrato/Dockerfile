# Usar una imagen base de OpenJDK para Java 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por el build
COPY target/contrato-0.0.1-SNAPSHOT.jar contrato-service.jar

# Exponer el puerto que utiliza la aplicación
EXPOSE 8004

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "contrato-service.jar"]
