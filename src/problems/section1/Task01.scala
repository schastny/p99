package problems.section1

class Task01 {

  def myLast(list: List[Any]): Any = {
    if (list.tail == Nil)
      list.head
    else
      myLast(list.tail)
  }

}
