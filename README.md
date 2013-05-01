#Desafio ADN

Solucion basada en https://github.com/JPABLOix/sequenceAlignment que hace uso de backtracking para la resolucion del problema.

## Por que esta basada en otra solucion?

Simplemente por que el desafio finalizaba el primero de Mayo, y estaba demasiado cercano al tiempo limite, por lo que se me ocurrio practicar Java (que lo deje de lado hace un par de años) pero con la diferencia que la solución implementada aprovecha la arquitectura de la maquina en donde se ejecuta, haciendo uso de los nucleos del procesador y asi efectuar la tarea con hebras. De este modo, la solucion puede servir para visualizar  el perfomance en cuanto a los dos lenguajes, y ver el comportamiento que tienen frente a un procesamiento de datos de este tipo. Cabe destacar que el resultado puede ser obviamente influenciado fuertemente por las estructuras de datos utilizadas, y no soy un super experto para decir que los elementos utilizados son los "optimos".

## Cosas por Hacer

Refactorizar el codigo y mejorar la legilibilidad del codigo.

## Como se ejecuta?

java -jar sequence.jar input.txt

Probado con jdk 1.7.0_21

