package problems.section1

/**
 * 1.07 (**) Flatten a nested list structure.<br/>
 * Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).<br/>
 * Example:<br/>
 *     ?- my_flatten([a, [b, [c, d], e]], X).<br/>
 *     X = [a, b, c, d, e]<br/>
 * Hint: Use the predefined predicates is_list/1 and append/3
 */
object Task07 {

  def flatten(list: List[Any]): List[Any] = {
    if (list == Nil) {
      Nil
    } else {
      val h = list.head
      val listFirst =
        if ( h.isInstanceOf[List[Any]] )
          flatten(h.asInstanceOf[List[Any]])
        else
          List(h)

      listFirst ++ flatten(list.tail)
    }
  }

  def flatten2(list: List[Any]): List[Any] = list match {
    case Nil                => Nil
    case (x:List[Any])::xs  => flatten2(x) ::: flatten2(xs)
    case x::xs              => List(x) ::: flatten2(xs)
  }

}
