package test;

import main.SensorAggregator;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

class SensorAggregatorTest {
    private SensorAggregator sensorAggregator = new SensorAggregator();
    SensorAggregatorTest() throws FileNotFoundException {}

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator_FirstDateEmpty() {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregator.getMax("T","01.01.2009 00:10:00", ""));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator_SecondDateEmpty()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregator.getMax("T","", "01.01.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator_SensorEmpty()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregator.getMax("","01.01.2009 00:10:00", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator_DatesNegative()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregator.getMax("T","01.01.2010 00:10:00", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator_fromDateToEarly()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregator.getMax("T","01.01.2008 00:10:00", "01.10.2009 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator_ToDateToLate()    {
        assertThrows(IllegalArgumentException.class, () -> sensorAggregator.getMax("T","01.01.2010 00:10:00", "01.10.2018 00:10:00"));
    }

    @org.junit.jupiter.api.Test
    void getMax_sensorAggregator() throws IOException, ParseException {
            assertEquals(sensorAggregator.getMax("T","01.01.2009 00:10:00", "01.10.2010 00:10:00"), 34.92);
    }
}