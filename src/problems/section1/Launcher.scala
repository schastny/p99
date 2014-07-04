package problems.section1

object Launcher {

  def main(args: Array[String]) {
//    testTask01
//    testTask02
//    testTask03
    testTask04
  }

  def testTask01 {
    println {
      new Task01() lastElement List(1,2,3,45)
    }
  }

  def testTask02 {
    println {
      new Task02() lastButOneElement List(1,2,3,4,5,6,7)
    }
  }

  def testTask03 {
    println {
      new Task03() elementAt(List(1,2,3), 2)
    }
  }

  def testTask04 {
    println {
      new Task04() countElements List(1,2,3,4)
    }
  }

}