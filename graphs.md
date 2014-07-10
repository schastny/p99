##Графы

**Предварительное замечание: Словарь понятий в теории графов не всегда постоянен. 
Некоторые авторы используют одинаковые слова для описания различных понятий. Иногда же разные слова объясняют один и тот же термин. Я надеюсь, что наши определения свободны от противоречивых толкований.**  

**Граф определяется как совокупность множества вершин (узлов) и рёбер (связей между вершинами).**  

![alt text](https://github.com/schastny/p99/raw/master/img/graph1.gif)  
Существует несколько способов представления графов в Прологе. 

Один из методов - представлять каждую вершину отдельно как одно целевое утверждение (факт). 
Таким образом граф, представленный выше может быть записан как следующий предикат:

    edge(h,g).
    edge(k,f).
    edge(f,b).    
    ...

Мы называем такую запись **edge-clause form**. 
Очевидно, что таким образом невозможно записать изолированные вершины.  

Другой метод - записывать весь граф как один объект. 
Исходя из определения графа как двух наборов (вершин и рёбер), 
мы можем использовать следующую запись на Пролог (показано для графа, приведённого на изображении):

    graph(
        [b, c, d, f, g, h, k], 
        [e(b, c), e(b, f), e(c, f), e(f, k), e(g, h)]
    )

Мы называем такую запись **graph-term form**. 
Отметьте, что списки хранятся в отсортированном виде, и на самом деле это наборы (Sets), без повторяющихся элементов. 
Каждое ребро появляется в списке ребёр только один раз. То есть, ребро из вершины x до вершины y представлено записью *e(x, y)*, 
а записи *e(y, x)* в списке нету.   
**Запись вида graph-term будет нашей формой представления графа по умолчанию**. 
В SWI-Prolog (реализация языка Пролог) есть предопределённые предикаты для работы с наборами.  

Третий вид представления - ассоциировать с каждой вершиной набор примыкающих вершин. 
Мы называем такую запись **adjacency-list form**. 
Запись для примера выше:

    [
        n(b,[c,f]), 
        n(c,[b,f]), 
        n(d,[]), 
        n(f,[b,c,k]), 
        ...
    ]

Приведённые методы представления являются валидными записями на Пролог и поэтому хорошо подходят для автоматической обработки,
но при этом их синтаксис не очень читабельный для пользователя. 
Набирать записи в таком формате для пользователя будет достаточно трудно и можно допустить ошибку. 
Мы можем определить более компактную и понятную для человека запись:   
Граф будет записываться как список атомов и терминов типа X-Y (то есть фукнтор '-' с арностью 2)
Атомы будут обозначать изолированные вершины, а термин X-Y - описывать рёбра. 
Если выясняется, что X - конец ребра, то он автоматически определяется, как вершина. 
Наш пример выше может быть описан следующим образом:  

    [b-c, f-c, g-h, d, f-b, k-f, h-g]

Мы будем называть такую запись **human-friendly form**. 
Как показано на примере, список не обязательно должен быть отсортирован и даже может содержать одно и то же ребро несколько раз. 
Отметьте также изолированную вершину d. 
(Вообще-то, изолированные вершины могут быть и не атомами в Прологе, а например составными терминами: d(3.75,blue) вместо простого d).

![alt text](https://github.com/schastny/p99/raw/master/img/graph2.gif)  
Если рёбра имеют направление, то из называют дугами. 
**Дуга** — это ориентированное ребро. Дуги записываются в виде упорядоченных пар. 
А сам граф — **ориентированный** или орграф (directed graph, digraph). 
Для записи ориентированных графов форма записи немного меняется. 
Например, граф, изображённый на картинке, записывается следующим образом:  

*Arc-clause form*

    arc(s,u).
    arc(u,r).
    ...
    
*Graph-term form*

    digraph([r,s,t,u,v],[a(s,r),a(s,u),a(u,r),a(u,s),a(v,u)])

*Adjacency-list form*

    [n(r,[]),n(s,[r,u]),n(t,[]),n(u,[r]),n(v,[u])]
(Отметьте, что в данной записи не будет информации, является ли этот граф простым или ориентированным)

*Human-friendly form*

    [s > r, t, u > r, s > u, u > s, v > u] 

![alt text](https://github.com/schastny/p99/raw/master/img/graph3.gif)  
И наконец, графы и орграфы могут иметь дополнительную информацию, добавленную к вершинам и рёбрам (дугам). 
Для вершин это не проблема, так как мы без труда можем заменить единичный символ на совтавной термин, например city('London',4711). 
Тогда как для рёбер нам придётся расширить нашу нотацию.
Графы с дополнительной информацией, прикреплённой к рёбрам, называются **помеченный граф** (labeled graph). 

*Arc-clause form*

    arc(m,q,7).
    arc(p,q,9).
    arc(p,m,5).
    
*Graph-term form*

    digraph([k,m,p,q],[a(m,p,7),a(p,m,5),a(p,q,9)])
    
*Adjacency-list form*

    [n(k,[]),n(m,[q/7]),n(p,[m/5,q/9]),n(q,[])]
(Отметьте, как информация по рёбрам была упакована с соответствующей вершиной в терм с функтором '/' и арностью 2)

*Human-friendly form*

    [p>q/9, m>q/7, k, p>m/5]

Нотация для помеченных графов так же может использоваться для так называемых мультиграфов ([multigraph](http://en.wikipedia.org/wiki/Multigraph)), 
в которых разрешено иметь более одного ребра (дуги) между двумя вершинами.  

**6.01 (\*\*\*) Преобразования**  
Напишите методы для преобразования между различными представлениями графов. 
Эта задача помечена тремя звёздами не ввиду своей сложности, 
а потому что здесь много работы по написанию методов для всех форм представления. 

**6.02 (\*\*) Путь от одной вершины к другой**  
Напишите метод path(G,A,B,P) для поиска ациклического пути P из вершины A в вершину B в графе G. 
Метод должен возвращать все возможные пути.

**6.03 (\*) Cycle from a given node**  
Напишите метод cycle(G,A,P) для поиса замкнутого пути (цикла), начинающегося в заданной вершине A в графе G. 
Метод должен возвращать все возможные варианты решения.

**6.04 (\*\*) Построить все каркасные (остовные) деревья**  
![alt text](https://github.com/schastny/p99/raw/master/img/p83.gif)
*Каркасное дерево* [Spanning tree](http://en.wikipedia.org/wiki/Spanning_tree) состоит из некоторого подмножества рёбер графа, 
таких, что из любой вершины графа можно попасть в любую другую вершину, двигаясь по этим рёбрам, и в нём нет циклов.  

Напишите метод s_tree(Graph,Tree) для построения всех возможных каркасных деревьев для заданного графа.
Используя данный метод, определите, сколько каркасных деревьев существует у графа, приведённого слева на картинке.
Строчное представление к данному графу находится в файле [p6_04.dat](https://github.com/schastny/p99/raw/master/files/p6_04.dat) 
Когда у вас будет корректная реализация s_tree/2, используйте её для определения двух других полезных методов: 
is_tree(Graph) и is_connected(Graph). 
Оба метода не должны занять у вас много времени!

**6.05 (\*\*) Construct the minimal spanning tree**  
![alt text](https://github.com/schastny/p99/raw/master/img/p84.gif)
Write a predicate ms_tree(Graph,Tree,Sum) to construct the minimal spanning tree of a given labelled graph. 
Подсказка: Use the algorithm of Prim. A small modification of the solution of 6.04 does the trick. 
The data of the example graph to the right can be found in the file p6_05.dat.

**6.06 (\*\*) Graph isomorphism**  
Two graphs G1(N1,E1) and G2(N2,E2) are isomorphic if there is a bijection f: N1 -> N2 such that 
for any nodes X,Y of N1, X and Y are adjacent if and only if f(X) and f(Y) are adjacent.

Write a predicate that determines whether two graphs are isomorphic. 
Подсказка: Use an open-ended list to represent the function f. 

**6.07 (\*\*) Node degree and graph coloration**  
a) Write a predicate degree(Graph,Node,Deg) that determines the degree of a given node.
b) Write a predicate that generates a list of all nodes of a graph sorted according to decreasing degree.
c) Use Welch-Powell's algorithm to paint the nodes of a graph in such a way that adjacent nodes have different colors.

**6.08 (\*\*) Depth-first order graph traversal**  
Write a predicate that generates a depth-first order graph traversal sequence. 
The starting point should be specified, and the output should be a list of nodes 
that are reachable from this starting point (in depth-first order).

**6.09 (\*\*) Connected components**  
Write a predicate that splits a graph into its connected components.

**6.10 (\*\*) Bipartite graphs**  
Write a predicate that finds out whether a given graph is bipartite.
     
**6.11 (\*\*\*) Generate K-regular simple graphs with N nodes**  
In a K-regular graph all nodes have a degree of K; i.e. the number of edges incident in each node is K. 
How many (non-isomorphic!) 3-regular graphs with 6 nodes are there?

See also the table of results in p6_11.txt. 

[Предыдущая глава](multiwaytrees.md) | [Оглавление](README.md) | [Следующая глава](misc.md)