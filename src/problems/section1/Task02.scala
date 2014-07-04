package problems.section1

object Task02 {

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

  private def lastButOne(list: List[Any]): Any = {
    if (list.tail.tail == Nil)
      list.head
    else
      lastButOne(list.tail)
  }

}
