package problems.section1

object Launcher {

  def main(args: Array[String]) {
    val list = List(1,2,3,44,6)
    val x = new Task01().myLast(list)
    println(x)
  }

}