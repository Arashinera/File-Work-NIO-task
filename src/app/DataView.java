package app;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DataView {
    public static int choice;
    public static String filePath;

    public static void Choice() {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        do {
            try {
                System.out.println("""
                        Tell me what do you want to do?
                        1) Create and write file
                        2) Read File""");
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Your choice must be Integer Value.");
                System.exit(0);
            }
        } while (choice < 1 || choice > 2);

        if (choice == 1) {
            DataProvider.getFileWriteData();
            DataOutput.getOutput(FileWriteService.handleFileNameData());
            DataOutput.getOutput(FileWriteService.handleFileTextData(Paths.get(DataProvider.stringPath), DataProvider.fileText));
        } else {
            filePath = Constants.BASE_PATH + DataProvider.getFileReadData() + ".txt";
            DataOutput.getOutput(FileReadService.getFileData(Path.of(filePath)));
        }

    }
}
