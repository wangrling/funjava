package tutorials.classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Filtering {

    public static void main(String[] args) {
        Path dir = Paths.get("src/main/java/tutorials/classes/");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
                "*.{java,class,jar}")) {

            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }

        } catch (IOException e) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can // only be thrown by newDirectoryStream.
            System.err.println(e);
        }
    }
}
