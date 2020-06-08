import scala.annotation._
import scala.math._

object Main {

  def digits(i : Int) : Int =
    if(i < 0) abs(i).toString.length else i.toString.length

  def digitsRecursive(i : Int) : Int =
    if(i < 0) digitsRecursiveHelp(abs(i), 1) else digitsRecursiveHelp(i, 1)

  @scala.annotation.tailrec
  def digitsRecursiveHelp(i : Int, sum : Int) : Int =
    if(i <= 9) sum
    else digitsRecursiveHelp(i/10, sum = sum + 1)


  def g(n : Int) : Int =
    gHelp(n, 1, 0)

  @tailrec def gHelp(n : Int, g1 : Int, g2 : Int) : Int =
    if(n == 1) g1
    else gHelp(n - 1, 2 * g1 + 3 * g2, g1)


  def isPerfect(input: Int) : Boolean =
    if(isPerfectHelp(input, 0, 1) == input) true else false

  @scala.annotation.tailrec
  def isPerfectHelp(numberToCheck: Int, sum: Int, mod: Int) : Int =
    if(numberToCheck == mod) sum
    else isPerfectHelp(numberToCheck, sum = if(numberToCheck%mod == 0) sum+mod else sum, mod=mod+1)


  def isISBNFormat(str: String): Boolean =
    str.matches("\\d-\\d{3}-\\d{5}-\\d")


  @tailrec def isISBNHelp(listOfNumbers: List[String], checkSum : Int): Boolean =
    if(listOfNumbers.isEmpty && checkSum % 11 == 0) true
    else if(listOfNumbers.isEmpty && checkSum % 11 != 0) false
     else isISBNHelp(listOfNumbers.drop(1), checkSum + (listOfNumbers.length * listOfNumbers.head.toInt))

  def isISBN(str: String): Boolean =
    if(isISBNFormat(str)) isISBNHelp(("""\d""".r findAllIn str).toList, 0)
    else false

    def main(args: Array[String]): Unit = {
      print("Hello World!")
  }
}