# 🥊 Frank Bruno's Boxing — Hoja de ruta del alumnado

> **Kata de programación Java** · DAM / DAW · Fundamentos de programación  
> Comprueba uno a uno los siguientes ítems antes de entregar tu solución.

---

## 1. Estructura y organización del proyecto

- [ ] El proyecto está organizado en paquetes (`edu.badpals.brunosbox`).
- [ ] Cada clase reside en el paquete correcto y el fichero se llama igual que la clase pública.
- [ ] Existe una clase `Brunosbox` con método `main()` como punto de entrada.

---

## 2. Abstracción, legibilidad y diseño

- [ ] Los nombres de clases, métodos y variables son descriptivos y siguen las convenciones Java (camelCase / PascalCase).
- [ ] El código es legible: se evitan «números mágicos», bloques excesivamente largos y comentarios innecesarios.
- [ ] Se han separado responsabilidades en clases distintas (abstracción adecuada).
- [ ] Se reutiliza la lógica común en lugar de duplicar código (p. ej. `parseBoxerRoundScore` en las distintas implementaciones de `Round`).

---

## 3. Encapsulamiento y ocultación de información

- [ ] Los atributos de todas las clases son `private`.
- [ ] Se accede a los datos exclusivamente a través de métodos públicos (getters / setters).
- [ ] Los métodos de uso interno son `private` (p. ej. `parseBoxerRoundScore()`, `addRound()`, `setJudgeScoreCard()`).
- [ ] Se usa `final` en atributos que no deben modificarse tras la construcción (p. ej. `private final String roundScore`).
- [ ] La lista `rounds` se expone de forma segura mediante `Collections.unmodifiableList()`.

---

## 4. Principios SOLID

- [ ] **SRP** *(Single Responsibility Principle)*: cada clase tiene una única razón para cambiar. `ScoreCard` gestiona la tarjeta, `RoundFactory` crea rounds, cada implementación de `Round` modela un tipo de asalto.
- [ ] **OCP** *(Open/Closed Principle)*: es posible añadir un nuevo tipo de asalto (nueva clase que implemente `Round`) sin modificar `ScoreCard` ni `RoundFactory` internamente, solo extendiéndola.
- [ ] **LSP** *(Liskov Substitution Principle)*: cualquier implementación de `Round` (`RegularRound`, `KnockdownRound`, `PointsDeducted`) puede usarse donde se espera un `Round` sin alterar el comportamiento.
- [ ] **ISP** *(Interface Segregation Principle)*: la interfaz `Round` es pequeña y específica; solo declara `getRedBoxerScore()` y `getBlueBoxerScore()`.
- [ ] **DIP** *(Dependency Inversion Principle)*: `ScoreCard` depende de la abstracción `Round`, no de implementaciones concretas.

---

## 5. Patrón de diseño Estrategia (GoF)

- [ ] Se ha definido la interfaz `Round` (estrategia).
- [ ] Existen al menos tres clases concretas que implementan la interfaz `Round`:
  - [ ] `RegularRound` — asalto normal `10-9` / `9-10`.
  - [ ] `KnockdownRound` — asalto con derribo `10-8` / `8-10`.
  - [ ] `PointsDeducted` — asalto con deducción de puntos `1, 8 - 10` / `10 - 8 ,1`.
- [ ] `ScoreCard` actúa como contexto del patrón: almacena una colección de `Round` y delega el cálculo de puntos en cada estrategia.
- [ ] `RoundFactory` centraliza la creación de la estrategia correcta según la cadena de puntuación.
- [ ] El diagrama de clases UML del patrón Estrategia está implementado correctamente.

---

## 6. Interfaces y clases

- [ ] `Round` está definida como **interfaz** (visibilidad de paquete).
- [ ] Sus métodos (`getRedBoxerScore()`, `getBlueBoxerScore()`) son `public` por defecto al estar en una interfaz.
- [ ] Las clases `RegularRound`, `KnockdownRound` y `PointsDeducted` implementan `Round` con `implements`.
- [ ] Se usa `@Override` en todos los métodos que sobrescriben o implementan un contrato.
- [ ] `@Override toString()` está implementado en `RegularRound`, `KnockdownRound`, `PointsDeducted` y `ScoreCard`.

---

## 7. Tipos de datos y conversiones

- [ ] Las puntuaciones de los asaltos se almacenan como `byte`, no como `String`.
- [ ] Se realiza correctamente el parseo de `String` a `byte` con `Byte.parseByte()`.
- [ ] Se aplica **casting de `byte` a `int`** al acumular puntuaciones (p. ej. `.map(Byte::intValue)`).
- [ ] Se aplica **casting de tipo** al obtener el resultado de `RoundFactory.getRound()` (p. ej. `(RegularRound)`, `(KnockdownRound)`, `(PointsDeducted)`).
- [ ] Se utiliza el tipo envolvente `Byte` (autoboxing/unboxing) donde corresponde.

---

## 8. Colecciones — `List` y `ArrayList`

- [ ] `ScoreCard` declara la colección de asaltos como `List<Round>` (interfaz).
- [ ] La implementación concreta utilizada es `ArrayList<Round>`.
- [ ] Se accede a los elementos de la lista con iteración (bucle `for-each`).
- [ ] Se usa `Collections.unmodifiableList()` para devolver una vista no modificable de la lista.
- [ ] Se conoce la diferencia entre declarar con `List<>` e instanciar con `new ArrayList<>()`.

---

## 9. `Optional<>`

- [ ] Se usa `Optional<Round>` en `loadJudgeScoreCard()` para gestionar el posible retorno `null` de `RoundFactory.getRound()`.
- [ ] Se utiliza `Optional.ofNullable()` para envolver el resultado.
- [ ] Se utiliza `Optional.ifPresent()` para añadir el round a la lista solo si no es nulo.

---

## 10. Streams y expresiones lambda

- [ ] Se usa la API de Streams (`stream()`) para calcular la puntuación final de cada boxeador.
- [ ] Se utilizan las operaciones intermedias `map()` y la operación terminal `reduce()`.
- [ ] Se usan referencias a métodos (`Round::getRedBoxerScore`, `Byte::intValue`, `Integer::sum`).
- [ ] En los tests se emplea `stream().filter()` y `stream().allMatch()` para verificar el tipo de los rounds.

---

## 11. Sobrecarga y operador ternario / `if-else`

- [ ] Se utiliza `if-else` o el operador ternario en la lógica de `RoundFactory.getRound()` para seleccionar la estrategia correcta.
- [ ] Se comprueba `null` antes de procesar la cadena de puntuación.
- [ ] Se usa `String.equalsIgnoreCase()` para comparar sin distinguir mayúsculas/minúsculas.

---

## 12. Mutabilidad de variables

- [ ] Los atributos que no deben cambiar tras la construcción se declaran `final`.
- [ ] Las variables locales que acumulan valores se declaran sin `final` (p. ej. `redBoxerScoreTotal`).
- [ ] Los atributos de puntuación final (`redBoxerFinalScore`, `blueBoxerFinalScore`) se calculan de forma perezosa (*lazy*) y se cachean.

---

## 13. Visibilidad de métodos

- [ ] Los métodos públicos forman la API de la clase; los métodos internos son `private`.
- [ ] La interfaz `Round` y sus implementaciones tienen la visibilidad de paquete apropiada (sin modificador de acceso donde corresponda).
- [ ] `RoundFactory.getRound()` es `public static`.

---

## 14. Excepciones

- [ ] Se gestiona correctamente el caso en que `RoundFactory.getRound()` devuelve `null` (mediante `Optional`).
- [ ] Se contempla qué ocurre si el array de puntuaciones contiene valores `null`.

---

## 15. Dependencias externas

- [ ] Se usa la librería **`ascii-table` (com.github.freva)** para mostrar la tabla de puntuaciones en consola.
- [ ] Se añade la dependencia **JUnit Jupiter** para los tests unitarios.
- [ ] Se añade la dependencia **Jacoco** para medir la cobertura de código.
- [ ] Se añade la dependencia **Guava** (Google) si se usa en alguna parte del proyecto.

---

## 16. Tests unitarios

> ### 🔴🟢🔁 Desarrollo guiado por tests (TDD)
>
> Los casos de test **no son una verificación final**: son el **punto de partida** del desarrollo.
> Sigue el ciclo clásico de TDD antes de escribir cada clase o método:
>
> 1. 🔴 **Red** — escribe el test antes que el código de producción; debe fallar porque la funcionalidad todavía no existe.
> 2. 🟢 **Green** — implementa el mínimo código necesario para que ese test pase.
> 3. 🔁 **Refactor** — limpia y mejora el código sin romper ningún test.
>
> Empieza siempre por el test más sencillo y avanza de forma incremental.
> Cada test debe cubrir **una única responsabilidad**.

- [ ] **`RegularRound` — parseo de cadena y conversión a `byte`**
  - *Intención*: verificar que, dada la cadena `"10-9"`, el boxeador rojo obtiene la puntuación `10` y el azul `9`, y que los valores se almacenan como `byte`. Garantiza que `parseBoxerRoundScore()` extrae correctamente cada parte de la cadena.

- [ ] **`KnockdownRound` — puntuaciones correctas**
  - *Intención*: comprobar que un asalto con derribo asigna `10` al ganador y `8` al derribado. Valida que la lógica de penalización extra por knockdown es correcta.

- [ ] **`PointsDeducted` — puntuaciones con deducción**
  - *Intención*: asegurar que cuando se descuenta un punto a un boxeador (p. ej. `"1, 8 - 10"`) el resultado final refleja la deducción. Cubre el caso en que la cadena contiene comas y espacios adicionales.

- [ ] **`ScoreCard` — carga de tarjeta con rounds regulares**
  - *Intención*: dado un array de cadenas de puntuación válidas, verificar que `loadJudgeScoreCard()` crea el número correcto de rounds, que todos son instancias de `RegularRound` y que quedan almacenados en la lista interna. Permite practicar TDD sobre la construcción del objeto `ScoreCard`.

- [ ] **`ScoreCard` — carga de tarjeta con rounds `null` (resultado: 0 rounds)**
  - *Intención*: garantizar que cuando el array de entrada contiene únicamente valores `null`, no se añade ningún round a la lista. Verifica la robustez frente a entradas inválidas y el correcto uso de `Optional.ifPresent()`.

- [ ] **`ScoreCard` — conteo correcto de `KnockdownRound`**
  - *Intención*: tras cargar una tarjeta mixta, verificar que el número de rounds de tipo `KnockdownRound` coincide con los esperados. Practica el uso de `stream().filter().count()` y obliga a implementar `RoundFactory` correctamente.

- [ ] **`ScoreCard` — conteo correcto de `PointsDeducted`**
  - *Intención*: análogo al anterior pero para rounds con deducción de puntos. Comprueba que `RoundFactory` selecciona la estrategia adecuada según el formato de la cadena de puntuación.

- [ ] **`ScoreCard` — puntuación final correcta de cada boxeador**
  - *Intención*: verificar que `getRedBoxerFinalScore()` y `getBlueBoxerFinalScore()` devuelven la suma acumulada correcta tras procesar todos los rounds. Valida el pipeline de Streams (`map` + `reduce`) y el casting de `byte` a `int`.

- [ ] El porcentaje de **cobertura de código (Jacoco)** es razonablemente alto (≥ 80 %).
- [ ] Los casos de test son **eficientes**: no se repiten innecesariamente, cubren casos límite.

---

## 17. Configuración del proyecto — Maven o Gradle

- [ ] Existe un fichero `pom.xml` (Maven) **o** `build.gradle` (Gradle) válido y bien configurado.
- [ ] Se declaran correctamente todas las dependencias con su `groupId`, `artifactId` y `version`.
- [ ] El proyecto compila y pasa los tests con `mvn test` / `gradle test`.
- [ ] Se genera un **fat JAR** (JAR con dependencias) ejecutable:
  - Maven: `maven-assembly-plugin` con `jar-with-dependencies`.
  - Gradle: tarea `shadowJar` o similar.
- [ ] El **Manifest** del JAR incluye la clase principal (`Main-Class: edu.badpals.brunosbox.Brunosbox`).
- [ ] Se declara la versión de Java correcta (`maven.compiler.source/target` o `sourceCompatibility`).

---

## 18. Control de versiones — Git

- [ ] Existe un fichero **`.gitignore`** que excluye `target/`, `build/`, `.class`, `.idea/`, etc.
- [ ] Los mensajes de commit siguen el estándar **Conventional Commits** (`feat:`, `fix:`, `refactor:`, `test:`, `docs:`, `chore:`…). Indica el componente afectado y el mensaje en infinitivo describiendo el propósito de la acción.
- [ ] Existe un **repositorio remoto** conectado en GitHub (`git remote -v`).
- [ ] Se han utilizado **ramas** (`git branch`) para el desarrollo de funcionalidades.
- [ ] Existe un fichero **`README.md`** en la raíz del repositorio con descripción del proyecto, instrucciones de compilación y ejecución.

---

## 19. Historias de usuario

- [ ] Se han redactado **historias de usuario** que describen los requisitos del kata.
- [ ] Las historias de usuario están vinculadas a las clases / funcionalidades implementadas.

---
