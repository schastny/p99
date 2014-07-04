package problems.section1

object Task04 {

  /**
   * 1.04 (*) Find the number of elements of a list.
   * @param list
   * @return
   */
  def countElements(list: List[Any]): Int = {
    if (list == Nil)
      0
    else
      countInternal(list.tail, 1)
  }

  private def countInternal(list: List[Any], count: Int): Int = {
    if (list==Nil)
      count
    else
      countInternal(list.tail, count+1)
  }

}
