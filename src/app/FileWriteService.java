package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteService {

    public String createNewFile(String path) {


        try {
            Files.createFile(Path.of(path));
        } catch (FileAlreadyExistsException exception) {
            return "File already exists. Try another title" + exception.getMessage();
        } catch (IOException exception) {
            return "Something wrong... Please, Try again" + exception.getMessage();
        }

        return "Process done. File has created.";
    }

    public String newTextToFile(Path path, String text) {

        try {
            Files.writeString(path, text);
        } catch (IOException exception) {
            return "Something wrong... Please, Try again" + exception.getMessage();
        }

        return "Your text recorded in: " + path;
    }

    public static String handleFileNameData() {
        return new FileWriteService().createNewFile(Paths.get(Constants.BASE_PATH, DataProvider.fileName + ".txt").toString());
    }

    public static String handleFileTextData(Path stringPath, String fileText) {
        return new FileWriteService().newTextToFile(Paths.get(String.valueOf(stringPath)), fileText);
    }
}
