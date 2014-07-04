package problems.section1

object Task05 {

  /**
   * 1.05 (*) Reverse a list.
   * @param list
   * @return reversed list
   */
  def reverseList(list: List[Any]): List[Any] = {
    if (list==Nil)
      Nil
    else
      reverseList(list.tail) :+ list.head
  }

}
