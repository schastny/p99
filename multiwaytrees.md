##N-арные деревья (Multiway Trees)

![alt text](https://github.com/schastny/p99/raw/master/img/p70.gif)
N-арное дерево состоит из узлового элемента и (возможно) набора потомков, которые в свою очередь также являются N-арными деревьями. 
N-арное дерево никогда не может быть пустым. Набор потомков часто называют лесом.  

В Прологе N-арное дерево записывают термином t(X,F), 
где X - узловой элемент, а F - лес потомков (список в Прологе).  
Приведённое на картинке дерево может быть представлено следующей записью:  

    T = 
        t(
            a, 
            [
                t(
                    f, 
                    [
                        t(g, [])
                    ]
                ), 
                t(  c, 
                    []
                ), 
                t(
                    b, 
                    [
                        t(d, []), 
                        t(e, [])
                    ]
                )
            ]
        )

**5.01 (\*) Проверить, является ли данный объект N-арным деревом**  
Напишите предикат istree/1, который возвращает true только в том случае, если его аргумент - это N-арное дерево.  
Пример:

    ?- istree(t(a,[t(f,[t(g,[])]),t(c,[]),t(b,[t(d,[]),t(e,[])])])).
    Yes

**5.02 (\*) Посчитать количество узлов N-арного дерева**  
Напишите метод nnodes/1 для подсчёта узлов N-арного дерева.  
Пример:

    ?- nnodes(t(a,[t(f,[])]),N).
    N = 2

Напишите ещё одну версию метода, который позволял бы реализовать flow pattern (o,i) 
(Write another version of the predicate that allows for a flow pattern (o,i)).

**5.03 (\*\*) Построение дерева из строки**  
![alt text](https://github.com/schastny/p99/raw/master/img/p70.gif)
Мы предполагаем, что узлы N-арного дерева содержат в качестве значения единичные символы. 
В посделовательности, полученной при обходе дерева в глубину (depth-first), используется специальный символ ^, 
который обозначает переход предыдущий уровень при обходе.  

Следуя этим правилам, дерево, изображённое на картинке, может быть представлено как строка: 

    afg^^c^bd^e^^^

Определите синтаксис строки и напишите метод tree(String,Tree) для построения дерева по заданной строке. 
Сделайте так, чтобы ваш метод смог работать в обоих направлениях.  

**5.04 (\*) Опередлить длину внутренних путей дерева**  
Длиной внутренних путей N-арного дерева назовём общую длину всех путей от узлового элемента до узлов дерева. 
По этому определению, дерево с диаграммы к задаче 5.03 имеет длину внутренних путей, равную 9.  

Напишите метод ipl(Tree,IPL) для подсчёта длины внутренних путей (+,-).  
(Write a predicate ipl(Tree,IPL) for the flow pattern (+,-))

**5.05 (\*) Construct the bottom-up order sequence of the tree nodes**  
Write a predicate bottom_up(Tree,Seq) which constructs the bottom-up sequence of the nodes of the multiway tree Tree. 
Seq should be a Prolog list.

What happens if you run your predicate backwords?

**5.06 (\*\*) Lisp-like tree representation**  
There is a particular notation for multiway trees in Lisp. 
Lisp is a prominent functional programming language, which is used primarily for artificial intelligence problems. 
As such it is one of the main competitors of Prolog. 
In Lisp almost everything is a list, just as in Prolog everything is a term.

The following pictures show how multiway tree structures are represented in Lisp.  
![alt text](https://github.com/schastny/p99/raw/master/img/p73.png)  

Note that in the "lispy" notation a node with successors (children) in the tree is always the first element in a list, followed by its children. 
The "lispy" representation of a multiway tree is a sequence of atoms and parentheses '(' and ')', which we shall collectively call "tokens". 
We can represent this sequence of tokens as a Prolog list; 
e.g. the lispy expression (a (b c)) could be represented as the Prolog list ['(', a, '(', b, c, ')', ')']. 
Write a predicate tree_ltl(T,LTL) which constructs the "lispy token list" LTL if the tree is given as term T in the usual Prolog notation.  

Пример:

    ?- tree_ltl(t(a,[t(b,[]),t(c,[])]),LTL).
    LTL = ['(', a, '(', b, c, ')', ')']

As a second, even more interesting exercise try to rewrite tree_ltl/2 in a way that the inverse conversion is also possible: 
Given the list LTL, construct the Prolog tree T. Use difference lists.

[Предыдущая глава](binarytrees.md) | [Оглавление](README.md) | [Следующая глава](graphs.md)