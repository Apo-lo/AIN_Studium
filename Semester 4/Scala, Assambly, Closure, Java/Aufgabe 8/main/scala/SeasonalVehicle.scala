class SeasonalVehicle(private val capacity: Int, private val licensePlate: String, private val startingMonthOfSeason: Int, private val endingMonthOfSeason: Int)
  extends Vehicle(capacity, licensePlate) {

  require(startingMonthOfSeason < endingMonthOfSeason && validMonths(startingMonthOfSeason) && validMonths(endingMonthOfSeason))

  def validMonths(month: Int) : Boolean =
    0 < month && month <= 12


  def getStartingMonth: Int = startingMonthOfSeason
  def getEndingMonth: Int = endingMonthOfSeason


  private def calculateProportionOfYear: Float =
    12 / ((getEndingMonth + 1) - getStartingMonth.toFloat)

  override def calculateTax: Int = {
    (super.calculateTax / calculateProportionOfYear).toInt
  }


  override def toString: String =
    "License Plate: " + getLicensePlate + " Capacity: " + getCapacity + "\nFirst Month: " + getStartingMonth + " Last Month: " + getEndingMonth + "\nTax: " + calculateTax + "€"
}
