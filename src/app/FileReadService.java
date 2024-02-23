package app;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadService {

    public String readFromFile(String path) {

        try {
            return Files.readString(
                    Path.of(path));
        } catch (FileNotFoundException exception) {
            return "File not found... Please, try again " + exception.getMessage();
        } catch (IOException exception) {
            return "Something wrong " + exception.getMessage();
        }
    }

    public static String getFileData(Path file) {
        return new FileReadService().readFromFile(String.valueOf(file));
    }
}
