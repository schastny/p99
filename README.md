##P-99: Ninety-Nine Prolog Problems (P-99: 99 задач на прологе)  
Original: https://sites.google.com/site/prologsite/prolog-problems  
Автор: Werner Hett    

Данный задачник поможет читателю попрактиковаться в логическом программировании.  

Ваша задача - найти наиболее элегантное решение предложенной проблемы. Эффективность важна, но логическая стройность является приоритетом. Некоторые из простых задач могут быть решены с использованием встроенных в язык библиотек. Хотя полезней будет, если вы попытаетесь найти своё собственное решение.  

Каждый метод, который вы напишете, должен быть снабжён комментарием. В комментариях не следует слепо описывать какие операторы или конструкции вы использовали. Вместо этого попытайтесь описать логику, алгоритм, который вы реализовали. Также укажите, какие аргументы и каких типов вы используете.  

Задачи имеют различный уровень сложности. Помеченные одной звёздочкой (\*) - лёгкие. 
Если вы раньше сталкивались с подобными задачами, то вы без проблем должны решать задачу с одной звёздочкой за несколько (скажем 15) минут. 
Задачи, помеченные двумя звёздочками (\*\*) - среднего уровня сложности. 
Если вы опытный программист на Prolog, то решение задачи с двумя звёздочками не должно у вас занять больше 30-90 минут. 
Задачи, помеченные тремя звёздочками (\*\*\*) являются сложными. 
Вам может понадобиться несколько часов и больше для того, чтобы найти хорошее решение.  

##Задачи
###Списки

Список может быть либо пустым, либо состоять из головного элемента (head) и хвоста (tail), который в свою очередь является списком. В прологе пустой список помечается [], а непустой - [H|T], где H - головной элемент, T - хвост.

**1.01 (\*) Найти последний элемент списка.**    
Пример:  

    ?- my_last(X,[a,b,c,d]).    
    X = d  
    
**1.02 (\*) Найти предпоследний элемент списка.**  

**1.03 (\*) Найти К-тый элемент списка.**  
Первый элемент списка имеет порядковый номер - 1.  
Пример:  

    ?- element_at(X,[a,b,c,d,e],3).
    X = c

**1.04 (\*) Найти количество элементов в списке.**  

**1.05 (\*) Перевернуть список.**

**1.06 (\*) Определить, является ли список палиндромом.**  
Палиндром должен одинаково читаться в обоих направлениях, например [x,a,m,a,x].

**1.07 (\*\*) Сделать плоской структуру из вложенных списков.**  
Преобразовать список, содержащий списки в качестве элементов, в плоский список, заменяя каждый список его элементами (рекурсисвно).  
Пример:  

    ?- my_flatten([a, [b, [c, d], e]], X).
    X = [a, b, c, d, e]

    Подсказка: Используйте готовые конструкции is_list/1 и append/3

**1.08 (\*\*) Удалить идущие подряд дубликаты элементов списка.**  
Если список содержит повторяемые элементы, они должны быть заменены на одиночную копию повторяемого элемента. Порядок элементов не должен меняться.   
Пример:

    ?- compress([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
    X = [a,b,c,a,d,e]

**1.09 (\*\*) Разложить дубликаты элементов по подспискам.**  
Если список содержит повторяемые элементы, они должны быть помещены в отдельные вложенные подсписки.  
Пример:

    ?- pack([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
    X = [[a,a,a,a],[b],[c,c],[a,a],[d],[e,e,e,e]]

**1.10 (\*) Кодирование повторов для списка.**  
Используйте результаты выполнения задачи 1.09 для реализации алгоритма сжатия данных методом [кодирования длин серий](http://en.wikipedia.org/wiki/Run-length_encoding). 
Последовательные дубликаты элементов кодируются записью [N,E], где N - это количество дубликатов элемента E.  
Пример:

    ?- encode([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
    X = [[4,a],[1,b],[2,c],[2,a],[1,d][4,e]]

**1.11 (\*) Модификация алгоритма кодирования повторов.**  
Измените результат выполнения задачи 1.10 такми образом, что если элемент не имеет дубликатов, он просто копируется в результирующий список. 
Только элементы с дубликатами заменяйте записью [N,E].
Пример:

    ?- encode_modified([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
    X = [[4,a],b,[2,c],[2,a],d,[4,e]]

**1.12 (\*\*) Разархивируйте список, запакованный алгоритмом кодирования повторов.**    
Для закодированного списка, полученного в задаче 1.11, постройте его изначальный список с дубликатами.   

**1.13 (\*\*) Кодирование повторов для списка (решение напрямую).**  
Реализуйте алгоритм сжатия методом кодирования повторов напрямую. То есть, не создавайте подсписки, содержащие дубликаты, как в задаче 1.09, а просто считайте их. Так же, как и в задаче 1.11, упростите результат, заменяя записи [1,X] на X.  

Пример:

    ?- encode_direct([a,a,a,a,b,c,c,a,a,d,e,e,e,e],X).
    X = [[4,a],b,[2,c],[2,a],d,[4,e]]

**1.14 (\*) Повторить элементы списка.**  
Пример:

    ?- dupli([a,b,c,c,d],X).
    X = [a,a,b,b,c,c,c,c,d,d]

**1.15 (\*\*) Повторить элементы списка заданное количество раз.**  
Пример:

    ?- dupli([a,b,c],3,X).
    X = [a,a,a,b,b,b,c,c,c]

Что будет являться результатом данного выражения?
 
    ?- dupli(X,3,Y).

**1.16 (\*\*) Удалить каждый N-ный элемент списка.**  
Пример:

    ?- drop([a,b,c,d,e,f,g,h,i,k],3,X).
    X = [a,b,d,e,g,h,k]

**1.17 (\*) Разбить список на две части с заданной длиной первой части.**  
Сделайте это без использования методов встроенных в язык библиотек.  

Пример:

    ?- split([a,b,c,d,e,f,g,h,i,k],3,L1,L2).
    L1 = [a,b,c]
    L2 = [d,e,f,g,h,i,k]

**1.18 (\*\*) Извлеките подсписок из списка.**  
Для заданных I и K, подсписком будет список с элементами с I-того по K-тый (с обеих сторон включительно).
Первый элемент имееть порядковый номер 1.

Пример:

    ?- slice([a,b,c,d,e,f,g,h,i,k],3,7,L).
    X = [c,d,e,f,g]

**1.19 (\*\*) Сдвинуть список на N позиций влево.**
Примеры:

    ?- rotate([a,b,c,d,e,f,g,h],3,X).
    X = [d,e,f,g,h,a,b,c]

    ?- rotate([a,b,c,d,e,f,g,h],-2,X).
    X = [g,h,a,b,c,d,e,f]

Подсказка: Используйте встроенные в язык методы length/2 и append/3, и результаты задачи 1.17.

**1.20 (\*) Удалить K-тый элемент из списка.**  
Пример:

    ?- remove_at(X,[a,b,c,d],2,R).
    X = b
    R = [a,c,d]

**1.21 (\*) Вставить элемент в список на заданную позицию.**  
Пример:

    ?- insert_at(alfa,[a,b,c,d],2,L).
    L = [a,alfa,b,c,d]

**1.22 (\*) Создать список, содержащий все целые числа заданного диапазона.**  
Пример:

    ?- range(4,9,L).
    L = [4,5,6,7,8,9]

**1.23 (\*\*) Извлечь заданное количество случайно выбранных элементов из списка.**  
Извлечённые элементы поместите в результирующий список.  
    
Пример:

    ?- rnd_select([a,b,c,d,e,f,g,h],3,L).
    L = [e,d,a]

Подсказка: Используйте встроенный генератор случайных чисел random/2 и результаты задачи 1.20.

**1.24 (\*) Лотерея: Выведите на экран N различных случайных чисел из диапазона 1..M.**  
Извлечённые элементы поместите в результирующий список.  
Пример:

    ?- rnd_select(6,49,L).
    L = [23,1,17,33,21,37]

Подсказка: Комбинируйте решения задач 1.22 и 1.23.

**1.25 (\*) Сгенерируйте случайную перестановку элементов списка.**  
Пример:

    ?- rnd_permu([a,b,c,d,e,f],L).
    L = [b,a,d,c,e,f]

Подсказка: Используйте решение к задаче 1.23.

**1.26 (\*\*) Generate the combinations of K distinct objects chosen from the N elements of a list**
In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficients). For pure mathematicians, this result may be great. But we want to really generate all the possibilities (via backtracking).

Пример:
    ?- combination(3,[a,b,c,d,e,f],L).
    L = [a,b,c] ;
    L = [a,b,d] ;
    L = [a,b,e] ;
    ...

**1.27 (\*\*) Group the elements of a set into disjoint subsets.**
    a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a predicate that generates all the possibilities via backtracking.

Пример:
    ?- group3([aldo,beat,carla,david,evi,flip,gary,hugo,ida],G1,G2,G3).
    G1 = [aldo,beat], G2 = [carla,david,evi], G3 = [flip,gary,hugo,ida]
    ...

    b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

Пример:

    ?- group([aldo,beat,carla,david,evi,flip,gary,hugo,ida],[2,2,5],Gs).
    Gs = [[aldo,beat],[carla,david],[evi,flip,gary,hugo,ida]]
    ...

Note that we do not want permutations of the group members; i.e. [[aldo,beat],...] is the same solution as [[beat,aldo],...]. However, we make a difference between [[aldo,beat],[carla,david],...] and [[carla,david],[aldo,beat],...].

You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".

**1.28 (\*\*) Sorting a list of lists according to length of sublists**
    a) We suppose that a list (InList) contains elements that are lists themselves. The objective is to sort the elements of InList according to their length. E.g. short lists first, longer lists later, or vice versa.

Пример:

    ?- lsort([[a,b,c],[d,e],[f,g,h],[d,e],[i,j,k,l],[m,n],[o]],L).
    L = [[o], [d, e], [d, e], [m, n], [a, b, c], [f, g, h], [i, j, k, l]]

    b) Again, we suppose that a list (InList) contains elements that are lists themselves. But this time the objective is to sort the elements of InList according to their length frequency; i.e. in the default, where sorting is done ascendingly, lists with rare lengths are placed first, others with a more frequent length come later.

Пример:

    ?- lfsort([[a,b,c],[d,e],[f,g,h],[d,e],[i,j,k,l],[m,n],[o]],L).
    L = [[i, j, k, l], [o], [a, b, c], [f, g, h], [d, e], [d, e], [m, n]]

    Note that in the above example, the first two lists in the result L have length 4 and 1, both lengths appear just once. The third and forth list have length 3; there are two list of this length. And finally, the last three lists have length 2. This is the most frequent length.
