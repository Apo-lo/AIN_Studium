package test;

import main.LineReader;

import java.io.StringReader;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LineReaderTest {
    String filename = "Das ist Line 1\nDas ist Line 2";
    String empty = "";
    String twoNewLines = "\n\n";

    StringReader emptyString = new StringReader(empty);
    StringReader testString = new StringReader(filename);
    StringReader stringTwoNewLines = new StringReader(twoNewLines);

    LineReader emptyLineReader = new LineReader(emptyString);
    LineReader testLineReader = new LineReader(testString);
    LineReader testTwoNeLines = new LineReader(stringTwoNewLines);

    @org.junit.jupiter.api.Test
    void testStringhasNext() {
        assert testLineReader.hasNext();
    }

    @org.junit.jupiter.api.Test
    void testStringnext() {
        assertEquals("Das ist Line 1", testLineReader.next());
    }

    @org.junit.jupiter.api.Test
    void testStringIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            emptyLineReader.next();
        });
    }

    @org.junit.jupiter.api.Test
    void testStringWithTwoNewLinesHasNext() {
        assert testTwoNeLines.hasNext();
    }
}