

# 🌙 LunaAprende – App de Estudio y Trivia para DUOC UC

LunaAprende es una aplicación móvil desarrollada en Kotlin, creada como proyecto académico en Duoc UC.  
El objetivo actual es ofrecer herramientas básicas de estudio por medio de un sistema de trivia y funciones iniciales que permite crear usuarios y capturar apuntes mediante la cámara.

Este README describe solo lo que hemos desarrollado hasta ahora.

---

## 📌 Funcionalidades desarrolladas actualmente

### 🔐 1. Login y Registro con Base de Datos
- Registro de nuevos usuarios usando Room Database.  
- Validación de credenciales durante el login.  
- Almacenamiento local.

### 🏠 2. Menú principal
Pantalla central que permite acceder a las funciones implementadas:
- Subir Apunte  
- Quiz  
- Volver al inicio de sesión 

### 📷 3. Subir Apunte – Uso de Cámara
- La app abre la cámara del dispositivo.  
- Permite tomar una fotografía.  
- La imagen capturada se muestra inmediatamente en pantalla.  
(Actualmente no se almacena de forma permanente, solo se visualiza.)

### ❓ 4. Quiz con API Externa

- Se obtienen 3 preguntas desde una API REST externa.
- La app recibe el JSON, lo convierte a objetos Kotlin y construye el quiz dinámicamente.
- Las preguntas varían en cada ejecución.
- El usuario selecciona sus respuestas y al final se muestra el resultado básico.


---

## 🛠 Tecnologías utilizadas

### Lenguaje y Framework
- Kotlin  
- Jetpack Compose  
- Material Design 3  

### Base de Datos
- Room Database (usuarios)

### Integraciones
- Camera
- API externa para las preguntas del quiz

---

## 📂 Estructura de carpetas

- ui: Pantallas y componentes visuales.
- ui/theme: Personalización de colores y estilos.
- data/remote: Comunicación con servidores externos y consumo de APIs (Retrofit).
- model: Clases de datos y entidades.
- repository: Acceso y gestión de datos.
- viewmodel: Lógica de presentación y gestión de estados.

## 📂 Archivos principales en ui
- Inicio: Pantalla de inicio de sesión con validación de correo y contraseña. Permite ver/ocultar password y navega al menú tras iniciar sesión.
 - Menu: Menú principal con acceso directo al Quiz, a Subir Apuntes y a cerrar sesión.
- Navegacion: Control central de rutas. Administra la navegación entre Inicio, Registro, Menú, Quiz y Subir Apunte.
- Quiz: Quiz interactivo con preguntas, alternativas dinámicas, imágenes y modal de respuestas correctas o incorrectas.
- Registro: Formulario para crear cuenta con validación de nombre, correo, contraseña y edad. Muestra modal de éxito y redirige al menú.
- SubirApunte: Permite tomar una foto con la cámara, mostrarla en pantalla y confirmar la subida del apunte.

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio
   ```bash
   git clone https://github.com/naomiigit/LunaAprende/tree/n

2. Abrir el proyecto en Android Studio


3. Esperar la sincronización de Gradle


4. Ejecutar en un dispositivo o emulador Android




---

👩‍💻 Autoras

Francisca Guerrero
Estudiante de Analista Programador – Duoc UC

Naomi Villarroel
Estudiante de Analista Programador – Duoc UC
