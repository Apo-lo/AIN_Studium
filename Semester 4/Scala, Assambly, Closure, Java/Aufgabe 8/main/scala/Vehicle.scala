class Vehicle(private val capacity: Int, private val licensePlate: String) {
  require(licensePlate!=null && capacity>0 && licensePlate.matches("[A-Z]{1,3}-[A-Z]{1,2}-\\d{1,4}"))

  def getCapacity: Int = capacity
  def getLicensePlate: String = licensePlate

  def calculateTax: Int = (getCapacity / 100) * 5

  override def toString: String = "License Plate: " + getLicensePlate + " Capacity: " + getCapacity + "\nTax: " + calculateTax + " €"

}

private object Vehicle  {
  def apply(capacity: Int, licensePlate: String) = new Vehicle(capacity, licensePlate)

  def apply(capacity: Int, licensePlate: String, startingMonthOfSeason: Int, endingMonthOfSeason: Int) =
    new SeasonalVehicle(capacity, licensePlate, startingMonthOfSeason, endingMonthOfSeason)
}
