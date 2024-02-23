package app;

import java.util.Scanner;
import java.util.Locale;

public class DataProvider {

    public static String fileName;
    public static String fileText;

    public static String stringPath;

    public static void getFileWriteData() {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        System.out.println("Input file name, e.g. NewNote: ");
        fileName = input.nextLine();

        System.out.println("Input file text: ");
        fileText = input.nextLine();

        stringPath = Constants.BASE_PATH + fileName + ".txt";
    }

    public static String getFileReadData() {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        System.out.print("Input file name, e.g. NewNote: ");

        return input.nextLine();
    }

}
