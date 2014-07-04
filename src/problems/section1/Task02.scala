package problems.section1

class Task02 {

  /**
   * 1.02 (*) Find the last but one element of a list.
   * @param list
   * @return
   */
  def lastButOneElement(list: List[Any]): Any = {
    if (list.tail == Nil)
      Nil
    else if (list.tail.tail == Nil)
      list.head
    else
      lastButOne(list.tail)
  }

  def lastButOne(list: List[Any]): Any = {
    if (list.tail.tail == Nil)
      list.head
    else
      lastButOne(list.tail)
  }

}
