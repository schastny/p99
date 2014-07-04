package problems.section1

object Task06 {

  /**
   * 1.06 (*) Find out whether a list is a palindrome.<br/>
   * A palindrome can be read forward or backward; e.g. [x,a,m,a,x].   */
  def palindrome(list: List[Any]): Boolean = {
    checkHeads(list, Task05 reverseList list)
  }

  private def checkHeads(list: List[Any], reverse: List[Any]): Boolean = {
    if (list==Nil)
      true
    else if (!list.head.equals(reverse.head))
      false
    else
      checkHeads(list.tail, reverse.tail)
  }

}
