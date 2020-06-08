package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineReader implements Iterable<String>, Iterator<String> {
    private BufferedReader file;
    private String cachedLine;
    private boolean finished = false;

    public LineReader(Reader file_to_read){
        file = new BufferedReader(file_to_read);
    }
    @Override
    public boolean hasNext() {
        if (cachedLine != null) {
            return true;
        } else if (finished) {
            return false;
        } else {
            try {
                while (true) {
                    String line = file.readLine();
                    if (line == null) {
                        finished = true;
                        return false;
                    } else if (isValidLine(line)) {
                        cachedLine = line;
                        return true;
                    }
                }
            } catch(IOException ioe) {
                close();
                throw new IllegalStateException(ioe.toString());
            }
        }
    }
    @Override
    public String next() {
        return nextLine();
    }

    public String nextLine() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more lines");
        }
        String currentLine = cachedLine;
        cachedLine = null;
        return currentLine;
    }

    public Iterator<String> iterator(){
        return this;
    }

    public void close() {
        finished = true;
        cachedLine = null;
    }
    protected boolean isValidLine(String line) {
        return true;
    }
}

