package mentor.bookstore.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class JsoupServiceBooksToScrape {

    @Scheduled(fixedRate = 20, timeUnit = TimeUnit.SECONDS)
    public void getBooksToScrape() throws IOException {
        System.out.println("=".repeat(16).concat("START").concat("=".repeat(19)));
        for (int i = 1; i <= 10; i++) {
            String url = "https://books.toscrape.com/catalogue/page-".concat(String.valueOf(i)).concat(".html");
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(".product_pod");

            System.out.println("=".repeat(40));
            elements.forEach(element -> {
                String title = element.select("h3 > a").text();
                String price = element.select(".price_color").text();

                double actualPrice = Double.parseDouble(price.replace("£", ""));

                // list books between £40 - £50
                if (actualPrice < 50 && actualPrice > 40) {
                    System.out.println(title + " - " + price);
                }
            });
        }
        System.out.println("=".repeat(17).concat("END").concat("=".repeat(20)));
        System.out.println();
    }
}
