# Examen Productos - Guía de despliegue y uso

Este proyecto es una aplicación web Java EE para la gestión de productos, desarrollada con JSF, JPA (Hibernate) y PostgreSQL. El despliegue se realiza sobre Apache Tomcat.

## Requisitos

- **Java JDK 17 o superior**
- **Apache Maven**
- **Apache Tomcat 9.x** (recomendado para máxima compatibilidad)
- **PostgreSQL** (con la base de datos `productosdb` creada)
- **VS Code** (opcional, con extensión Community Server Connectors)

## Estructura del proyecto

- `src/main/java/com/examen/productos/`  
  Clases Java: entidades, beans y DAOs.
- `src/main/webapp/`  
  Archivos JSF (`.xhtml`) para la interfaz web.
- `src/main/resources/META-INF/persistence.xml`  
  Configuración de JPA/Hibernate y conexión a PostgreSQL.
- `pom.xml`  
  Configuración de dependencias Maven.

## Dependencias principales

Asegúrate de tener en tu `pom.xml` las dependencias para JSF, JPA, Hibernate, PostgreSQL y anotaciones Java EE:

```xml
<dependency>
    <groupId>javax.faces</groupId>
    <artifactId>javax.faces-api</artifactId>
    <version>2.3</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.15.Final</version>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
</dependency>
```

## Configuración de la base de datos

En `src/main/resources/META-INF/persistence.xml`:

- Cambia los valores de usuario, contraseña y URL si tu configuración de PostgreSQL es diferente.

## Despliegue

1. **Compila y empaqueta el proyecto:**
   ```powershell
   mvn clean package
   ```
2. **Copia el archivo WAR generado en `target/` a la carpeta `webapps` de Tomcat 9.**
3. **Inicia Tomcat.**
4. **Accede a la aplicación en tu navegador:**
   ```
   http://localhost:8080/telefonos-app/
   ```
   (o el nombre del WAR generado)

## Notas importantes

- Si usas Tomcat 10 o superior, debes migrar todo tu código y dependencias a `jakarta.*`.
- Para evitar errores de compilación y despliegue, mantén la compatibilidad entre tus dependencias y el servidor de aplicaciones.
- El archivo `index.xhtml` debe declarar correctamente los namespaces JSF:
  ```xml
  xmlns:h="http://java.sun.com/jsf/html"
  xmlns:f="http://java.sun.com/jsf/core"
  ```

## Solución de problemas

- **Errores de compilación por clases no encontradas:**  
  Verifica que las dependencias en `pom.xml` coincidan con los imports en tu código.
- **Errores de despliegue en Tomcat 10+:**  
  Usa Tomcat 9 para evitar incompatibilidades con `javax.*`.

---

**Desarrollado por:**  
Equipo Examen Productos