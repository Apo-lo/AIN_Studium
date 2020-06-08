
object Main {
  def main(args: Array[String]) : Unit = {
    val bmw = Vehicle(1000, "VS-F-7331")
    val vw =  Vehicle(1000, "VS-TS-7331", 1, 6)

    println(bmw)
    print(vw)
  }
}