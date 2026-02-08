/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchingAlgorithm {
    public static void main(String[] stringArray) {
        Object object;
        Object object2;
        Object object3;
        String[] stringArray2;
        String string;
        Object object4;
        String string2 = "reviews.csv";
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        try {
            object4 = new BufferedReader(new FileReader(string2));
            try {
                while ((string = ((BufferedReader)object4).readLine()) != null) {
                    stringArray2 = string.split(",");
                    if (stringArray2.length <= 1) continue;
                    object3 = stringArray2[1];
                    object2 = stringArray2[0];
                    object = Arrays.asList(((String)object3).split("\\s+"));
                    arrayList.add(object);
                    arrayList2.add(object2);
                }
            }
            finally {
                ((BufferedReader)object4).close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        string2 = "targetedwords.txt";
        string = ",";
        stringArray2 = new ArrayList();
        try {
            object3 = new BufferedReader(new FileReader(string2));
            try {
                while ((object4 = ((BufferedReader)object3).readLine()) != null) {
                    object2 = new ArrayList();
                    for (String string3 : object = ((String)object4).split(string)) {
                        ((ArrayList)object2).add(string3);
                    }
                    stringArray2.add(object2);
                }
            }
            finally {
                ((BufferedReader)object3).close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        object3 = new String[stringArray2.size()][];
        for (int i = 0; i < stringArray2.size(); ++i) {
            object = (ArrayList)stringArray2.get(i);
            object3[i] = ((ArrayList)object).toArray(new String[0]);
        }
        ArrayList<String> arrayList3 = new ArrayList<String>();
        object = new ArrayList();
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < arrayList.size(); ++i) {
            d = 0.0;
            d2 = 0.0;
            for (int j = 0; j < ((List)arrayList.get(i)).size(); ++j) {
                for (int k = 0; k < ((Object)object3).length; ++k) {
                    if (!((String)((List)arrayList.get(i)).get(j)).equals(object3[k][0])) continue;
                    d += Double.parseDouble((String)object3[k][1]);
                    d2 += Double.parseDouble((String)object3[k][2]);
                }
            }
            System.out.println((String)arrayList2.get(i) + " Dog Rating: " + d);
            System.out.println((String)arrayList2.get(i) + " Cat Rating: " + d2);
            System.out.println();
            if (d >= 5.0 && d > d2) {
                arrayList3.add((String)arrayList2.get(i));
            }
            if (!(d2 >= 5.0) || !(d2 > d)) continue;
            object.add((String)arrayList2.get(i));
        }
        try {
            Files.write(Paths.get("dogList.txt", new String[0]), arrayList3, new OpenOption[0]);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            Files.write(Paths.get("catList.txt", new String[0]), (Iterable<? extends CharSequence>)object, new OpenOption[0]);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
