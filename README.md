# Message Filter App

Aplicación Spring Boot que filtra palabras prohibidas en mensajes de texto.

## Características

- Filtrado de palabras prohibidas en mensajes de texto
- Reemplazo de palabras prohibidas por símbolos (`!#?%@`)
- Interfaz de consola para interacción mediante terminal
- Interfaz web para interacción gráfica
- Implementación usando Spring AOP (Programación Orientada a Aspectos)
- Limitación configurable de palabras prohibidas por mensaje

## Lista de palabras prohibidas

Esta aplicación filtra las siguientes palabras prohibidas por defecto:
- palabrota
- insulto
- ofensa
- maldición
- improperio

Para personalizar esta lista, modifica el arreglo `prohibitedWords` en la clase `WordFilterService.java`.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.x
- Spring AOP
- Thymeleaf (para la interfaz web)
- Lombok
- Maven

## Estructura del proyecto

```
message-filter-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── messagefilterapp/
│   │   │               ├── aspect/
│   │   │               │   └── WordFilterAspect.java
│   │   │               ├── console/
│   │   │               │   └── ConsoleRunner.java
│   │   │               ├── controller/
│   │   │               │   └── MessageController.java
│   │   │               ├── model/
│   │   │               │   └── Message.java
│   │   │               ├── service/
│   │   │               │   └── WordFilterService.java
│   │   │               └── MessageFilterAppApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── index.html
│   │       ├── application.properties
│   └── test/
└── pom.xml
```

## Diagrama UML

![Diagrama UML](docs/uml-diagram.png)

## Configuración e instalación

### Requisitos previos

- Java 17 o superior
- Maven 3.6 o superior

### Pasos para ejecutar

1. Clonar el repositorio:
   ```
   git clone https://github.com/TU_USUARIO/message-filter-app.git
   ```

2. Navegar al directorio del proyecto:
   ```
   cd message-filter-app
   ```

3. Compilar y ejecutar la aplicación:
   ```
   mvn spring-boot:run
   ```

4. Acceder a la aplicación:
    - **Interfaz web:** Abrir navegador y visitar `http://localhost:8080`
    - **Interfaz de consola:** Interactuar a través de la terminal donde se ejecutó la aplicación

## Uso

### Interfaz web

1. Visita `http://localhost:8080` en tu navegador
2. Escribe un mensaje en el cuadro de texto
3. Haz clic en el botón "Filtrar Mensaje"
4. Observa el resultado filtrado

### Interfaz de consola

1. Sigue las instrucciones que aparecen en la consola
2. Escribe tu mensaje cuando se te solicite
3. Observa el mensaje filtrado como respuesta
4. Escribe 'salir' para terminar la aplicación

## Personalización

Para modificar el comportamiento de filtrado, puedes ajustar los siguientes parámetros en la clase `WordFilterService.java`:

- Lista de palabras prohibidas
- Caracteres de reemplazo (actualmente `!#?%@`)
- Número máximo de palabras prohibidas permitidas (actualmente 3)
