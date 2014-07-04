package problems.section1

object Task03 {

  /**
   *   1.03 (*) Find the K'th element of a list.<br/>
   *     The first element in the list is number 1.<br/>
   *     Example:<br/>
   *     ?- element_at(X,[a,b,c,d,e],3).<br/>
   *     X = c
   */
  def elementAt(list: List[Any], position: Int): Any = {
    if (list == Nil)
      Nil
    else if (position == 1)
      list.head
    else
      elementAt(list.tail, position-1)
  }

}
