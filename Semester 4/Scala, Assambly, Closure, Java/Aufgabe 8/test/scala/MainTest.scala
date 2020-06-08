import org.scalatest.FunSuite

class MainTest extends FunSuite {

  test("validVehicle") {
    Vehicle(1000, "VS-TS-1337")
  }

  test("invalidVehicleLicencePlate") {
    intercept[IllegalArgumentException]  {
      Vehicle(100, "-TST-11111")
    }
  }

  test("invalidVehicleCapacity") {
    intercept[IllegalArgumentException]  {
      Vehicle(0, "VS-TS-1337")
    }
  }

  test("vehicleCalculateTax") {
    assert(50 == Vehicle(1000, "VS-TS-1337").calculateTax)
  }

  test("validSeasonalVehicle") {
    Vehicle(1000, "VS-TS-1337", 1, 8)
  }

  test("invalidSeasonalVehicleStartingMonth") {
    intercept[IllegalArgumentException] {
      Vehicle(1000, "VS-TS-1337", -1, 8)
    }
  }

  test("invalidSeasonalVehicleEndinggMonth") {
    intercept[IllegalArgumentException] {
      Vehicle(1000, "VS-TS-1337", 1, 13)
    }
  }

  test("invalidSeasonalVehicleMonths") {
    intercept[IllegalArgumentException] {
      Vehicle(1000, "VS-TS-1337", 12, 7)
    }
  }

  test("SeasonalVehicleCalculateTax") {
    assert(25 == Vehicle(1000, "VS-V-1337", 1, 6).calculateTax)
  }

}
