# GitHub Activity CLI 📱

¡Bienvenido a **GitHub Activity CLI**! 👨‍💻👩‍💻

Este es un proyecto de línea de comandos (CLI) construido con **Spring Boot**. Te permite obtener la actividad reciente y los repositorios de un usuario de GitHub de manera sencilla. ¡Es fácil de usar y muy práctico para monitorear las actividades de tus usuarios favoritos de GitHub! 🔍

## 🎯 Objetivo del Proyecto

El objetivo principal de este proyecto es crear una interfaz de línea de comandos que:

- Permite obtener la actividad reciente de un usuario de GitHub.
- Permite obtener la lista de repositorios públicos de un usuario.
- Muestra información relevante como repositorios, eventos, fechas, URLs y descripciones.
- Ofrece una experiencia visual atractiva en la consola con colores y formatos personalizados.

## 🛠️ Tecnologías Utilizadas

1.  **Java 21**
2.  **Maven**
3.  **Spring Boot **
   

## 📂 Estructura del Proyecto (Simplificada)

```
📦 github-activity-cli
├── 📁 .mvn/
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java/com/github_activity_cli
│   │   │   ├── 📁 controller # (Si es una app web/API) o cli (Si es CLI pura)
│   │   │   │   └── GithubController.java / GithubCommands.java
│   │   │   ├── 📁 model      # Clases del dominio (Event, Repo)
│   │   │   │   ├── Event.java
│   │   │   │   └── Repo.java
│   │   │   ├── 📁 service    # Lógica de negocio (Llamadas a API GitHub)
│   │   │   │   └── GithubService.java
│   │   │   ├── 📁 util       # Clases de utilidad (DateFormatter)
│   │   │   │   └── DateFormatter.java
│   │   │   └── GithubActivityCliApplication.java # Punto de entrada Spring Boot
│   │   └── 📁 resources
│   │       ├── 📁 static     # Archivos estáticos (si aplica)
│   │       ├── 📁 templates   # Plantillas (si aplica)
│   │       ├── application.properties # Configuración de Spring
│   │       └── banner.txt    # Banner de inicio (opcional)
│   └── 📁 test        # Pruebas unitarias/integración
├── 📁 target/       # Archivos generados por Maven (compilación)
├── 📄 .gitattributes
├── 📄 .gitignore
├── 📄 HELP.md       # Documentación adicional (si existe)
├── 📄 mvnw          # Maven Wrapper (Linux/Mac)
├── 📄 mvnw.cmd      # Maven Wrapper (Windows)
└── 📄 pom.xml       # Archivo de configuración de Maven
```


## 🔧 Comandos Disponibles

*(Asumiendo una ejecución como aplicación CLI compilada o vía Spring Shell)*

### 1. Obtener Actividad Reciente (`github-activity`)

Muestra la actividad reciente de un usuario de GitHub, incluyendo eventos como:

- Pusheo de commits.
- Creación de issues.
- Estrellas (stars) en repositorios.

**Ejemplo de uso:**

```bash
github-activity --username <nombre_usuario>
# O si es Spring Shell: shell:> github-activity --username <nombre_usuario>
```

**Ejemplo de salida:**

```text
══════════════════════════════════════════
   Actividad reciente de kamranahmedse
══════════════════════════════════════════

▶ Evento: PushEvent
  📌 Repositorio: developer-roadmap
  ⏳ Fecha: 24 de marzo de 2025, 07:34 a. m. UTC
----------------------------------------
```

### 2. Obtener Repositorios (`github-repo`)

Lista todos los repositorios públicos del usuario especificado y sus detalles, como la URL y la descripción.

**Ejemplo de uso:**

```bash
github-repo --username <nombre_usuario>
# O si es Spring Shell: shell:> github-repo --username <nombre_usuario>
```

**Ejemplo de salida:**

```text
📂 Lista de repositorios de kamranahmedse:
-----------------------------------------
🔹 developer-roadmap
   🔗 https://github.com/kamranahmedse/developer-roadmap
   📝 Conoce los caminos para convertirte en desarrollador.
-----------------------------------------
```

## 🎨 Colores en la Consola

Se utilizan colores ANSI para mejorar la legibilidad de la salida en la consola:

- 🔵 Azul: Para la URL de los repositorios.
- 🟢 Verde: Para el tipo de evento (ej. `PushEvent`).
- 🟡 Amarillo: Para advertencias o notas importantes (si aplica).

## 📝 Notas Importantes

- Este proyecto utiliza la API pública de GitHub para obtener la información. No requiere autenticación para datos públicos.
- Asegúrate de tener conexión a internet para que los comandos funcionen correctamente.
- Para ejecutar los comandos, necesitarás compilar el proyecto (ej. con `mvn package`) y ejecutar el JAR resultante, o usar `mvn spring-boot:run` si está configurado como aplicación Spring Shell.

## 💬 Contribuciones

¡Las contribuciones son bienvenidas! 😄 Si tienes sugerencias, mejoras o encuentras errores, no dudes en abrir un *issue* o enviar un *pull request*.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles (deberás crear este archivo si aún no existe).
