import Main._
import org.scalatest.FunSuite

class MainTest extends FunSuite {

  test("testIsISBN") {
    assert(isISBN("3-770-40001-1"))
    assert(!isISBN("3-770-400012-1"))
    assert(!isISBN("3-770-40001-2"))
  }

  test("testG") {
    assert(0==g(0))
    assert(1==g(1))
    assert(2==g(2))
    assert(7==g(3))
    assert(20==g(4))
  }

  test("testIsISBNFormat") {
    assert(isISBNFormat("3-770-40001-1"))
    assert(!isISBNFormat("3-770-400012-1"))
    assert(!isISBNFormat("3-770-40001=1"))
  }

  test("testDigits") {
    assert(1 == digits(1))
    assert(2 == digits(12))
    assert(3 == digits(123))
    assert(4 == digits(1234))
    assert(1 == digits(-1))
  }

  test("testDigitsRecursive") {
    assert(1 == digitsRecursive(1))
    assert(2 == digitsRecursive(12))
    assert(3 == digitsRecursive(123))
    assert(4 == digitsRecursive(1234))
    assert(1 == digitsRecursive(-1))
    assert(1 == digitsRecursive(0))
  }

  test("testIsPerfect") {
    assert(!isPerfect(5))
    assert(isPerfect(6))
    assert(isPerfect(28))
  }

}
