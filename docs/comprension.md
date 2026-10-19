# Comprensión del diseño — Enunciado B
**Nombre:** Alejandro Tafur Rodriguez
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_
por que modelo es solo el concepto general y siempre se usa uno especifico, como CNN o RNN.
este obliga a que todos tengan un metodo tipo entrenar(Dataset d). el sistema gana polimorfismo
ya que el programa puede poner a entrenar a cualquier modelo de la misma forma, sin importar cual
sea por dentro

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_
la diferencia es que tan unidos estan existir. en la composicion, el modelo nace dentro del experimento,
si se borra el experimento, el modelo tambien se borra pero en la agregacion
los experimentos solo estan guardados en en la plataforma y si se borra la plataforma, los experimentos
siguen existiendo sin problema

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_
ninguno es dueño del otro, son como 'compañeros de trabajo' por decirlo asi. es N:M por que puede estar en 
varios experimentos a la ves, y en un mismo experimento puede trabajar varias cosas. no es una composicion
por que si algo se sale o se borra, el experimento sigue y si se cancela el experimento, ese algo no desaparece

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_
la metrica es una herramienta que el modelo usa para sacar una cuenta y ya, no es un dato propio que deba guardar
siempre. la ventaja de mandarla por parametro es no gastar memoria guardando cosas fijas y poder usar la que 
necesitemos en el momento

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta:_
> en modelo se usa int[] por que desde que se creo el modelo ya se sabe cuantas epocas maximas va a tener, asi que
> un arreglo normal de tamaño fijo es mas rapido y suficiente. mientras que, en plataforma se usa arraylist por que
> no sabemos cuantos experimentos van a ir subiendo con el 
> tiempo y la lista tiene que poder agrandarse solo segun haga falta