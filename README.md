#Desafio ADN

Solucion basada en https://github.com/JPABLOix/sequenceAlignment que hace uso de backtracking para la resolucion del problema.

## Por que esta basada en otra solucion?

Simplemente por que el desafio finalizaba el primero de Mayo, y estaba demasiado cercano al tiempo limite, por lo que se me ocurrio practicar Java (que lo deje de lado hace un par de años) pero con la diferencia que la solución implementada aprovecha la arquitectura de la maquina en donde se ejecuta, haciendo uso de los nucleos del procesador y asi efectuar la tarea con hebras. De este modo, la solucion puede servir para visualizar  el perfomance en cuanto a los dos lenguajes, y ver el comportamiento que tienen frente a un procesamiento de datos de este tipo. Cabe destacar que el resultado puede ser obviamente influenciado fuertemente por las estructuras de datos utilizadas, y no soy un super experto para decir que los elementos utilizados son los "optimos".

## Cosas por Hacer

Refactorizar el codigo y mejorar la legilibilidad del codigo.

## Como se ejecuta?

java -jar sequence.jar input.txt

## Pruebas

El archivo input.txt contiene 128 sospechosos con dimensiones de cadenas diferentes generadasa por un programa que genera sospechosos aleatorios.

Probe la solucion haciendo uso de 4 nucleos (Mi Notebook) probando la solucion de https://github.com/JPABLOix/sequenceAlignment  y la mia con la misma entrada. Haciendo uso de Time de Unix, los resultados fueron:

 <pre>
$time java -jar sequence.jar input.txt
El culpable es el numero:65 (AGGAACGTATGTGCGGACTGCAGTATGTTGGGTCTGGCTGATAAATTAATCGACTGGTTGGCGAATCCACGATGCAGTGTTATAGAGCGGTTGCCTCGTGGG)
real    0m12.518s
user    0m22.577s
sys 0m0.648s
 </pre>

<pre>
$time php guilty.php input.txt
El culpable es el sospechoso número 65 (:AGGAACGTATGTGCGGACTGCAGTATGTTGGGTCTGGCTGATAAATTAATCGACTGGTTGGCGAATCCACGATGCAGTGTTATAGAGCGGTTGCCTCGTGGG).
real    0m13.716s
user    0m11.021s
sys 0m0.260s
</pre>

## EDIT

Para confirmar la super teoria de la estructuras de datos, agregue la biblioteca GUAVA de google para manejar los puntajes y cadenas ya calculadas. De este modo ejecute de nuevo las pruebas y los resultados cambiaron a mi favor:

 <pre>
$time java -jar sequence.jar input.txt
El culpable es el numero:65 (AGGAACGTATGTGCGGACTGCAGTATGTTGGGTCTGGCTGATAAATTAATCGACTGGTTGGCGAATCCACGATGCAGTGTTATAGAGCGGTTGCCTCGTGGG)
real    0m4.036s
user    0m7.396s
sys 0m0.332s
 </pre>

 Con este cambio se aprecia que el programa es 3 veces mas rapido.

 Probando con el archivo input256.txt, el cual contiene 256 sospechosos aleatorios, los resultados son:

<pre>
$time java -jar sequence.jar input.txt
El culpable es el numero:181 (AGCGCAACCGGAGATTGCTCGCCGTCAGTCTTGCGCTCTTTCGAGGAGATTTGGTACGATAGGTCAAACCGCGCCGCGAACTGCAGATAGCGGGAGTAGCCTGCGATGAGGCAC)
real    0m8.876s
user    0m18.141s
sys 0m0.588s
</pre>

<pre>
$time php guilty.php input.txt
El culpable es el sospechoso número 181 (AGCGCAACCGGAGATTGCTCGCCGTCAGTCTTGCGCTCTTTCGAGGAGATTTGGTACGATAGGTCAAACCGCGCCGCGAACTGCAGATAGCGGGAGTAGCCTGCGATGAGGCAC).
real    0m17.356s
user    0m17.073s
sys 0m0.220s
</pre>

## Nota
Si se generan cadenas de evidencia y sospechosos de larga magnitud, es probable que el Java Heap se llene, por lo que habria que aumentar el Heap (Ejemplo -Xmx 1024 )

## JDK
Probado con jdk 1.7.0_21

