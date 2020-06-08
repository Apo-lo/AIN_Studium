package main;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SensorAggregator {
    private String filename = "/Users/fh/FH/Semester 4/Programmiermodelle/Praktikum/Aufgabe 5/jena_climate_2009_2016.csv";
    private File file = new File(filename);
    private Reader reader = new FileReader(file);
    private LineReader lines = new LineReader(reader);

    public SensorAggregator() throws FileNotFoundException {
    }

    public double getMax(@NotNull String sensorName, @NotNull String from, @NotNull String to) throws ParseException    {

        correctImputsNotEmpty(sensorName, from, to);

        List<Double> valuesOfSensorData = new ArrayList<>();

        String[] firstLine = lines.next().split(",");

        Date fromAsDate = parseStringToDate(from);
        Date toAsDate = parseStringToDate(to);

        checkDatesAreCorrect(fromAsDate, toAsDate);

        int indexOfDateTime = getIndexOFDate(firstLine);
        int indexOfSensor = getIndexOfSensor(firstLine, sensorName);

        for (String line : lines) {
            String[] linesSplit = line.split(",");

            Date dateToCheck = parseStringToDate(linesSplit[indexOfDateTime]);

            if (dateComperator(dateToCheck, fromAsDate, toAsDate)) {
                valuesOfSensorData.add(Double.parseDouble(linesSplit[indexOfSensor]));
            }
            if (dateToCheck.compareTo(toAsDate) > 0) {
                break;
            }
        }
        return Collections.max(valuesOfSensorData);
    }


    int getIndexOFDate(@NotNull String[] arrayOfFirstLine) {
        for (int i = 0; i <= arrayOfFirstLine.length; i++) {
            if (arrayOfFirstLine[i].contains("Date Time")) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    int getIndexOfSensor(@NotNull String[] arrayOfFirstLine, String sensorName) {
        for (int i = 1; i <= arrayOfFirstLine.length; i++) {
            if (arrayOfFirstLine[i].contains(sensorName)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    void correctImputsNotEmpty(@NotNull String sensoreName, String from, String to)  {
        if (sensoreName.equals("") || from.equals("") || to.equals(""))    {
            throw new IllegalArgumentException();
        }
    }

    void checkDatesAreCorrect(@NotNull Date from, Date to) throws ParseException {
        Date firstDate = parseStringToDate("01.01.2009 00:10:00");
        Date lastDate = parseStringToDate("01.01.2017 00:00:00");

        if (from.compareTo(to) > 0 || from.compareTo(firstDate) < 0 || lastDate.compareTo(to) < 0)
            throw new IllegalArgumentException();
    }

    Date parseStringToDate(String dateToPars) throws ParseException {
        final SimpleDateFormat mayDateFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        return mayDateFormatter.parse(dateToPars);
    }

    boolean dateComperator(@NotNull Date dateToCheck, Date from, Date to) {
        return (dateToCheck.compareTo(from) >= 0 && dateToCheck.compareTo(to) <= 0);
    }
}