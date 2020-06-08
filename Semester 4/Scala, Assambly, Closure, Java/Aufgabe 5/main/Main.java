package main;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        SensorAggregator sensorAggregator = new SensorAggregator();
        SensorAggregatorStrict sensorAggregatorStrict = new SensorAggregatorStrict();
        System.out.println("The Max Value: " + sensorAggregator.getMax("T","01.01.2009 00:10:00", "01.10.2010 00:10:00"));
        System.out.println("The Max Value: " + sensorAggregatorStrict.getMax("Tdew", "01.01.2010 00:10:00", "01.01.2011 00:50:00"));
    }
}
