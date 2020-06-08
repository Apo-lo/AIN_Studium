package test;

import main.SensorAggregatorStrict;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class SensorAggregatorStrictTest {
    private SensorAggregatorStrict sensorAggregatorStrict = new SensorAggregatorStrict();
    SensorAggregatorStrictTest() throws FileNotFoundException {}

    @org.junit.jupiter.api.Test
    void getMax_SensorAggregatorStrict_FirstDateEmpty() {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregatorStrict.getMax("T","", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_SensorAggregatorStrict_SecondDateEmpty() {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregatorStrict.getMax("T","01.01.2010 00:10:00", ""));
    }

    @org.junit.jupiter.api.Test
    void getMax_SensorAggregatorStrict_SensorEmpty() {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregatorStrict.getMax("","01.01.2010 00:10:00", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_SensorAggregatorStrict_DatesNegative()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregatorStrict.getMax("T","01.01.2010 00:10:00", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_SensorAggregatorStrict_FromDateToEarly()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregatorStrict.getMax("T","01.01.2008 00:10:00", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_SensorAggregatorStrict_ToDateToLate()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregatorStrict.getMax("T","01.01.2010 00:10:00", "01.10.2019 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregatorStrict() throws ParseException {
        assertEquals(sensorAggregatorStrict.getMax("Tdew", "01.01.2010 00:10:00", "01.01.2011 00:50:00"), 19.66);
    }

}
