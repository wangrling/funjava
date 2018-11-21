package tutorials.classes;

import java.awt.event.ContainerEvent;
import java.io.IOException;
import java.nio.file.*;

import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Find {

    /**
     * A {@code FileVisitor} that finds
     * all files that match the
     * specified pattern.
     */
    public static class Finder extends SimpleFileVisitor<Path> {
        private final PathMatcher matcher;
        private int numMatches = 0;

        Finder(String pattern) {
            matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                numMatches++;
                System.out.println(file);
            }
        }

        // Prints the total number of matches to standard out.
        void done() {
            System.out.println("Matches: " + numMatches);
        }

        // Invoke the pattern matching method on each file.
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            find(path);

            return FileVisitResult.CONTINUE;
        }

        // Invoke the pattern matching method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            find(path);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
            System.err.println(e);
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get("src/main/java/");

        String pattern = "*.java";

        Finder finder = new Finder(pattern);
        Files.walkFileTree(startingDir, finder);

        finder.done();
    }
}
