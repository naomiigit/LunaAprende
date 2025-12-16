

# 🌙 LunaAprende – App de Estudio y Trivia para DUOC UC

LunaAprende es una aplicación móvil desarrollada en Kotlin, creada como proyecto académico en Duoc UC.  
El objetivo actual es ofrecer herramientas básicas de estudio por medio de un sistema de trivia y funciones iniciales que permite crear usuarios y capturar apuntes mediante la cámara.

Este README describe solo lo que hemos desarrollado hasta ahora.

---


## 📌 Funcionalidades desarrolladas actualmente

### 🔐 1. Inicio de Sesión y Registro de Usuarios
- Inicio de sesión y registro mediante **API REST externa**.
- Consumo del servicio utilizando **Retrofit**.
- Validación de credenciales desde el backend.
- Manejo de la sesión del usuario dentro de la aplicación.

---

### 🏠 2. Menú Principal
Pantalla central que permite acceder a las funcionalidades disponibles:
- Subir Apunte  
- Quiz  
- Cerrar sesión

---

### 📷 3. Subir Apunte – Uso de Cámara y Room
- Solicita permisos de cámara al usuario.
- Permite tomar una fotografía del apunte.
- La imagen capturada se **almacena localmente utilizando Room Database**.
- Uso de las entidades:
  - `Apunte.kt`
  - `ApunteDao.kt`
  - `AppDatabase.kt`

---

### ❓ 4. Quiz con API Externa
- Obtención de preguntas desde una **API REST externa**.
- Consumo del servicio mediante **Retrofit**.
- Conversión del JSON recibido a objetos Kotlin.
- Construcción dinámica del Quiz.
- El usuario selecciona sus respuestas y al final se muestra el resultado.

---

## 🛠 Tecnologías utilizadas

### Lenguaje y Framework
- Kotlin  
- Jetpack Compose  
- Material Design 3  

### Base de Datos
- Room Database (almacenamiento local de apuntes)

### Integraciones
- API REST externa (login, registro y quiz)
- Retrofit
- Cámara del dispositivo

---

📂 Estructura de carpetas

- ui: Pantallas y componentes visuales de la aplicación desarrollados con Jetpack Compose.

- ui/theme: Personalización de colores, tipografías y estilos usando Material Design 3.

- data/remote: Comunicación con servidores externos y consumo de APIs REST mediante Retrofit (login, registro y quiz).

- data/local: Persistencia local de apuntes utilizando Room Database.

- model: Clases de datos y entidades utilizadas en la aplicación.

- repository: Acceso y gestión de datos.

- viewmodel: Lógica de presentación y gestión de estados.


---

📂 Archivos principales en ui

- Inicio: Pantalla de inicio de sesión con validación de correo y contraseña. Permite ver u ocultar la contraseña y navega al menú tras iniciar sesión.

- Registro: Formulario para crear cuenta con validación de nombre, correo, contraseña y edad. Muestra un mensaje de éxito y redirige al flujo correspondiente.

- Menu: Menú principal con acceso directo al Quiz, a Subir Apuntes, a Mis Apuntes, selección de Dificultad y opción de cerrar sesión.

- Dificultad: Pantalla que permite seleccionar el nivel de dificultad del Quiz antes de comenzar la trivia.

- Quiz: Quiz interactivo con preguntas obtenidas desde una API externa, alternativas dinámicas y visualización del resultado final.

- SubirApunte: Permite tomar una fotografía utilizando la cámara del dispositivo, mostrarla en pantalla y confirmar la subida del apunte, el cual se almacena localmente mediante Room Database.

- MisApuntes: Pantalla que muestra el listado de apuntes guardados localmente. Permite visualizar los apuntes almacenados en la base de datos.

- Navegacion: Control central de rutas. Administra la navegación entre Inicio, Registro, Menú, Dificultad, Quiz, Subir Apunte y Mis Apuntes.

- theme: Configuración de colores, tipografías y estilos visuales de la aplicación.


---


## 🔐 Permisos utilizados

```bash
android.permission.CAMERA
android.permission.INTERNET

Además, se utiliza FileProvider para el manejo seguro de imágenes.


---

▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:


```bash
git clone https://github.com/naomiigit/LunaAprende

2. Abrir el proyecto en Android Studio.


3. Esperar la sincronización de Gradle.


4. Ejecutar en un dispositivo o emulador Android.



---

📌 Estado actual del proyecto

- Proyecto académico en desarrollo.

- Autenticación mediante API externa.

- Almacenamiento local de apuntes con Room.

- Quiz dinámico consumido desde API REST.

- Gestión de sesión con opción de cerrar sesión.



---

👩‍💻 Autoras

Francisca Guerrero
Estudiante de Analista Programador – Duoc UC

Naomi Villarroel
Estudiante de Analista Programador – Duoc UC
