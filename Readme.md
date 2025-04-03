# GitHub Activity CLI 📱

¡Bienvenido a **GitHub Activity CLI**! 👨‍💻👩‍💻

Este es un proyecto de línea de comandos (CLI) que he construido con **Spring Boot**. Te permite obtener la actividad reciente de un usuario de GitHub de manera sencilla. ¡Es fácil de usar y muy práctico para monitorear las actividades de tus usuarios favoritos de GitHub! 🔍

## 🎯 Objetivo del Proyecto

El objetivo principal de este proyecto es crear una interfaz de línea de comandos que:
- Permite obtener la actividad reciente de un usuario de GitHub.
- Muestra información relevante como repositorios, eventos y fechas.
- Ofrece una experiencia visual atractiva con colores y formatos personalizados.

## 🛠 Tecnologias

1. **Java 21** 
2. **Maven** 
3. **Spring Boot 3.4+** 

## 🔧 Comandos Disponibles

1. Obtener la actividad reciente de un usuario de GitHub
   
Ejemplo de uso:

github-activity --username <nombre_usuario>

Este comando mostrará la actividad reciente de un usuario de GitHub, incluyendo eventos como:
Pusheo de commits.
Creación de issues.
Estrellas en repositorios.

Ejemplo de salida:
══════════════════════════════════════════
   Actividad reciente de kamranahmedse
══════════════════════════════════════════

▶ Evento: PushEvent
  📌 Repositorio: developer-roadmap
  ⏳ Fecha: 24 de marzo de 2025, 07:34 a. m. UTC
----------------------------------------

2. Obtener los repositorios de un usuario de GitHub
   
Ejemplo de uso:

github-repo --username <nombre_usuario>

Este comando listará todos los repositorios públicos del usuario y sus detalles, como la URL y la descripción.

Ejemplo de salida:

📂 Lista de repositorios de kamranahmedse:
-----------------------------------------
🔹 developer-roadmap
🔗 https://github.com/kamranahmedse/developer-roadmap
Conoce los caminos para convertirte en desarrollador.
-----------------------------------------

## 🎨 Colores
He usado colores ANSI para mejorar la legibilidad de la consola, como:

🔵 Azul para la URL de los repositorios.

🟢 Verde para el tipo de evento.

🟡 Amarillo para advertencias.

📝 Notas
Este proyecto utiliza el API público de GitHub para obtener información.

Asegúrate de tener conexión a internet para que los comandos funcionen correctamente.

💬 Contribuciones
¡Me encantaría que contribuyas! 😄 Puedes abrir issues y pull requests para sugerir mejoras o corregir errores.

📄 Licencia
Este proyecto está bajo la licencia MIT.
