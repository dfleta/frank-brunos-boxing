
# Fichero instruccciones IA para elaborar checklist / roadmap para el alumnado

Este proyecto Java es un kata de programación para que el alumnado del ciclo de grado superior de desarrollo de aplicaciones multiplataforma aprenda distintos rudimentos de los fundamentos de programación en Java.

Analiza el código del proyecto y elabora un fichero markdown con una lista de items que el alumno/a debe implementar o usar en su solución. NO realices una rúbrica. Se trata de realizar un hoja de ruta o guía para el alumno/a. Tan solo lista los items a chequear su presencia o uso agrupados en epígrafes para facilitar la autocorrección del alumno/a.

Identifica todos los recursos Java que se ha usado y añádelos a la lista.

En particular, este kata se centra en el uso de la interfaz List y de la implementación ArrayList.

Incluye, al menos estos items:

Respecto a los estándares de codificación y buenas prácticas, y el diseño, incluye la evaluación de los 5 patrones de diseño SOLID e ten en cuenta que el patrón de diseño GoF que articula este diseño es el patrón estrategia.

Incluye items para chequear la configuración del proyecto con Maven o Gradle -a elección del alumno- y la configuración del control de versiones git.

Estos items son los que uso en la rúbrica de corrección. Han de estar presentes en la hoja de ruta que elabores. NO realices la rúbrica.

---
abstracción y legibilidad
Encapsulamiento
Ocultar la información
reutilización
Paquetes
Modularidad
reutilización de la clase Course
---
SRP
OCP
---
@Override toString() de Player
Casting de tipos byte a int, StrokePlay a GolfPlay
Sobrecarga de métodos
Lógica de item equals + hashcode
---
tipo enumerado: Definido, getPoints(), y Printarlo .values()
---

Colecciones / Estructura de datos
Acceso a byte[] de getPlayerCourse()
---
Optional<>
loop: uso de streams
if - else u operqador ternario Elvis
---
Interfaces
Clases abstractas
---
visibilidad métodos
mutabilidad variables
Excepciones
---
dependencias entre módulos: bajo acoplamiento
---
lógica de los métodos
código óptimo y eficiente  
---

test unidad:

- porcentaje de código cubierto
- eficiencia de los casos test
- dependencia Jacoco
- dependencia Guava

---
Historias de usuario
Implementación del diagrama de clases UML del patrón Estrategia
---
Maven /gradle:
(fat)JAR y Manifest
Proyecto Maven y POM valida? / Gradle tasks
.gitignore
coventional commit
Repo remoto coenctado en GitHub
Uso de ramas
Readme.md
