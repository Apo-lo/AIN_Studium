package main;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;

public class SensorAggregatorStrict extends SensorAggregator {

    final private String filename = "/Users/fh/FH/Semester 4/Programmiermodelle/Praktikum/Aufgabe 5/jena_climate_2009_2016.csv";
    final private Scanner scannerOfFile = new Scanner(new File(filename));

    public SensorAggregatorStrict() throws FileNotFoundException {
        super();
    }

    @Override
    public double getMax(@NotNull String sensorName, @NotNull String from, @NotNull String to) throws ParseException {

        correctImputsNotEmpty(sensorName, from, to);

        final String[] firstLine = scannerOfFile.nextLine().split(",");
        scannerOfFile.close();

        final Date fromAsDate = parseStringToDate(from);
        final Date toAsDate = parseStringToDate(to);
        checkDatesAreCorrect(fromAsDate, toAsDate);

        final int indexOfDate = getIndexOFDate(firstLine);
        final int indexOfSensor = getIndexOfSensor(firstLine, sensorName);

        try (final Stream<String> lines = Files.lines(Paths.get(filename))) {
            final OptionalDouble values = lines.map(line -> Arrays.asList(line.split(",")))
                    .skip(1)
                    .filter(line -> {
                        try {
                            return dateComperator(parseStringToDate(line.get(indexOfDate)), fromAsDate, toAsDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return false;
                    })
                    .map(line -> line.get(indexOfSensor))
                    .mapToDouble(Double::parseDouble)
                    .max();

            if(values.isPresent())
                return values.getAsDouble();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}