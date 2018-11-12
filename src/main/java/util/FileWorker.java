package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWorker {

    public String readText(String path) {
        StringBuilder text=new StringBuilder();
        try {
            Files.lines(Paths.get(path)).map(s -> s+"\n").forEach(text::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
