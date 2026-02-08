/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 *  org.jsoup.nodes.Element
 *  org.jsoup.select.Elements
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] stringArray) {
        String string = "https://www.goodreads.com/book/show/8715123-cats-vs-dogs#CommunityReviews";
        String string2 = "reviews.csv";
        List<String> list = Arrays.asList("Reviewer Name", "Review Text", "Rating", "Date", "Metadata");
        try (FileWriter fileWriter = new FileWriter(string2);){
            fileWriter.append(String.join((CharSequence)",", list));
            fileWriter.append("\n");
            Document document = Jsoup.connect((String)string).get();
            Elements elements = document.select(".ReviewsList .ReviewCard");
            for (Element element : elements) {
                String string3 = element.select(".ReviewerProfile__name").text();
                Object object = element.select(".ReviewText__content").text().replaceAll(",", "");
                String string4 = element.select(".RatingStars").attr("aria-label");
                string4 = string4.length() >= 9 ? string4.substring(7, 8) : "";
                String string5 = element.select(".ReviewCard__row a").text();
                String string6 = element.select(".ReviewerProfile__meta span").first().text();
                object = "\"" + ((String)object).replace("\"", "\\\"") + "\"";
                List<String> list2 = Arrays.asList(string3, object, string4, string5, string6);
                fileWriter.append(String.join((CharSequence)",", list2));
                fileWriter.append("\n");
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
