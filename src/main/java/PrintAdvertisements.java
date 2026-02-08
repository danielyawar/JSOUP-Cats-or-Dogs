/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAdvertisements {
    public static void main(String[] stringArray) {
        String string;
        String[] stringArray2;
        Object object;
        Object object2;
        String string2 = "reviews.csv";
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            object2 = new BufferedReader(new FileReader(string2));
            try {
                while ((object = ((BufferedReader)object2).readLine()) != null) {
                    stringArray2 = ((String)object).split(",");
                    if (stringArray2.length <= 0) continue;
                    string = stringArray2[0].trim();
                    arrayList.add(string);
                }
            }
            finally {
                ((BufferedReader)object2).close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        object2 = PrintAdvertisements.readListFromFile("dogList.txt");
        object = PrintAdvertisements.readListFromFile("catList.txt");
        stringArray2 = PrintAdvertisements.readStringFromFile("dogAdvertisement.txt");
        string = PrintAdvertisements.readStringFromFile("catAdvertisement.txt");
        for (String string3 : arrayList) {
            if (object2.contains(string3)) {
                System.out.println(string3 + ", " + (String)stringArray2);
                System.out.println();
            }
            if (!object.contains(string3)) continue;
            System.out.println(string3 + ", " + string);
            System.out.println();
        }
    }

    private static List<String> readListFromFile(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try (Scanner scanner = new Scanner(Paths.get(string, new String[0]));){
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine().trim());
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return arrayList;
    }

    private static String readStringFromFile(String string) {
        try {
            return new String(Files.readAllBytes(Paths.get(string, new String[0]))).trim();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return "";
        }
    }
}
