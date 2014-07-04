package problems.section1

object Task01 {

  /**
   * 1.01 (*) Find the last element of a list.<br/>
   * Example:<br/>
   * ?- my_last(X,[a,b,c,d]).<br/>
   * X = d<br/>
   * @param list
   * @return
   */
  def lastElement(list: List[Any]): Any = {
    if (list.tail == Nil)
      list.head
    else
      lastElement(list.tail)
  }

}
