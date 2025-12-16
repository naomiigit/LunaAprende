

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
- **Cerrar sesión y volver al inicio de sesión**

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

## 📂 Estructura de carpetas

com.duoc.lunaaprende │ ├── ui │   ├── Inicio │   ├── Registro │   ├── Menu │   ├── Quiz │   ├── SubirApunte │   ├── Navegacion │   └── theme │ ├── viewmodel │   ├── InicioViewModel.kt │   ├── RegistroViewModel.kt │   └── QuizViewModel.kt │ ├── repository │   ├── InicioRepository.kt │   ├── RegistroRepository.kt │   └── QuizRepository.kt │ ├── data │   ├── local │   │   ├── AppDatabase.kt │   │   ├── Apunte.kt │   │   └── ApunteDao.kt │   └── remote │       ├── ApiService.kt │       ├── RetrofitInstance.kt │       └── Session.kt │ ├── model │   ├── QuizModel.kt │   ├── RegistroModel.kt │   └── MensajesError.kt │ └── MainActivity.kt

---

## 📂 Archivos principales en `ui`

- **Inicio**:  
  Pantalla de inicio de sesión. Valida correo y contraseña y redirige al menú principal.

- **Registro**:  
  Formulario para crear una cuenta nueva. Envía los datos a la API y redirige al inicio o menú.

- **Menu**:  
  Menú principal con acceso al Quiz, Subir Apunte y **cerrar sesión**.

- **Quiz**:  
  Quiz interactivo con preguntas dinámicas obtenidas desde la API externa.

- **SubirApunte**:  
  Permite capturar una imagen usando la cámara y guardarla localmente.

- **Navegacion**:  
  Control central de rutas entre Inicio, Registro, Menú, Quiz y Subir Apunte.

- **theme**:  
  Configuración de colores, tipografías y estilos de la aplicación.

---

## 🔐 Permisos utilizados

```xml
android.permission.CAMERA
android.permission.INTERNET

Además, se utiliza FileProvider para el manejo seguro de imágenes.


---

▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:



git clone https://github.com/naomiigit/LunaAprende

2. Abrir el proyecto en Android Studio.


3. Esperar la sincronización de Gradle.


4. Ejecutar en un dispositivo o emulador Android.




---

📌 Estado actual del proyecto

Proyecto académico en desarrollo.

Autenticación mediante API externa.

Almacenamiento local de apuntes con Room.

Quiz dinámico consumido desde API REST.

Gestión de sesión con opción de cerrar sesión.



---

👩‍💻 Autoras

Francisca Guerrero
Estudiante de Analista Programador – Duoc UC

Naomi Villarroel
Estudiante de Analista Programador – Duoc UC

---