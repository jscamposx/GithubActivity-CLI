# 🚀 GitHub Activity CLI

Una herramienta de línea de comandos para consultar información de usuarios de GitHub, como su actividad reciente, repositorios e información de perfil.

---

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para construir la aplicación.
- **Spring Shell**: Framework para crear la interfaz de línea de comandos (CLI).
- **Maven**: Herramienta de gestión de proyectos y dependencias.
- **RestTemplate**: Cliente HTTP de Spring para interactuar con la API de GitHub.
- **Lombok**: Librería para reducir el código boilerplate (`@Data`).
- **Jackson**: Librería para la serialización y deserialización de JSON (`@JsonProperty`).

---

## 💂️ Estructura del Proyecto

```plaintext
📚 Proyecto
├── 📚 src
│   ├── 📚 main
│   │   ├── 📚 java
│   │   │   ├── 🏢 com.github_activity_cli  # Paquete principal de la aplicación
│   │   │   │   ├── 🛩️ controller           # Controladores para manejar los comandos CLI
│   │   │   │   ├── ⚠️ exceptions           # Manejo de excepciones personalizadas
│   │   │   │   ├── 📝 model                # Modelos de datos (Usuario, Repositorio, Evento)
│   │   │   │   ├── ⚙️ service               # Lógica de negocio y comunicación con la API de GitHub
│   │   │   │   ├── 🛠️ util                  # Utilidades como formateo de fechas y caché
│   │   │   │   └── 🚀 GithubActivityCliApplication.java  # Punto de entrada de la aplicación
│   ├── 📚 resources
│   │   ├── ⚙️ application.properties       # Configuraciones de la aplicación
│   │   └── 🎨 banner.txt                  # Banner ASCII para la CLI
├── 🧪 test                                # Pruebas automatizadas
├── 📝 pom.xml                             # Archivo de configuración de Maven
```

---

## ⚙️ Comandos Disponibles

Una vez que la aplicación esté en ejecución, puedes usar los siguientes comandos en tu terminal:

```sh
github-activity --username <nombre_de_usuario>
```
> Muestra la actividad reciente del usuario de GitHub especificado.

```sh
github-repo --username <nombre_de_usuario>
```
> Muestra la lista de repositorios públicos del usuario de GitHub especificado.

```sh
github-user --username <nombre_de_usuario>
```
> Muestra información detallada del usuario de GitHub especificado.

---

## 📤 Ejemplos de Output

### `github-activity --username octocat`

```plaintext
══════════════════════════════════════════
📢 Actividad reciente de octocat
══════════════════════════════════════════

▶ Tipo de evento: PushEvent 📌 Repositorio: octocat/Spoon-Knife ⏳ Fecha: 02 de abril de 2025, 02:56 PM UTC
▶ Tipo de evento: CreateEvent 📌 Repositorio: octocat/Hello-World ⏳ Fecha: 02 de abril de 2025, 01:30 PM UTC
... (más eventos)
```

### `github-repo --username octocat`

```plaintext
══════════════════════════════════════════
📚 Lista de repositorios de octocat
══════════════════════════════════════════

🔹 Nombre: Spoon-Knife 📎 URL: https://github.com/octocat/Spoon-Knife 📝 Descripción: This repo is for demonstration purposes only.
🔹 Nombre: Hello-World 📎 URL: https://github.com/octocat/Hello-World 📝 Descripción: (Sin descripción)
... (más repositorios)
```

### `github-user --username octocat`

```plaintext
══════════════════════════════════════════
👤 Información del usuario: Mona Lisa Octocat
══════════════════════════════════════════

🆔 ID: 583231
👉 Tipo de vista: User
📅 Cuenta creada en: 25 de enero de 2011, 05:49 PM UTC
📚 Repositorios públicos: 8
📝 Biografía: There once was a girl named Octocat.
```

---

## 🏃‍♂️ Cómo Ejecutar la Aplicación
(debes tener configurada tu terminal para tener la experiencia completa o ejecutar desde el codigo fuente)

1. Descarga el archivo `github-activity-cli-0.0.1-SNAPSHOT.jar` desde el repositorio.

2. Abre una terminal y navega a la ubicación donde guardaste el archivo `.jar`.

3. Ejecuta el siguiente comando:

```sh
java -jar github-activity-cli-0.0.1-SNAPSHOT.jar
```

---

🚀 ¡Disfruta usando **GitHub Activity CLI**!

