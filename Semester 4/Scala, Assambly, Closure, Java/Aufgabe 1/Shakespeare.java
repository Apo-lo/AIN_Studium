import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shakespeare {

    private String content;
    private String[] tests = { "hello world", "hello, world", "none,--","x??x hello world ", "  hello  !orld","!hello" };

    Shakespeare() throws IOException {
        content = new String(Files.readAllBytes(Paths.get("/Users/fh/FH/Semester 4/Programmiermodelle/Praktikum/Aufgabe 1/all-shakespeare.txt")));
    }

    public int wordCount(){
        int counter = 0;

        Pattern p = Pattern.compile("([a-z]|\\d|[-]){2,}(?=\\.|,|;|\n|\t|\\S)");
        Matcher m = p.matcher(content);

        while (m.find()){
            counter++;
        }

        return counter;
    }
}
