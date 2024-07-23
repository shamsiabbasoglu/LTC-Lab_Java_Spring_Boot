package mentor.bookstore.dto.responsedto.goodreadsdto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Root {
    private String imageUrl;
    private String bookId;
    private String workId;
    private String bookUrl;
    private String title;
    private ArrayList<Author> author;
    private String rating;
    private String totalRatings;
    private String publishedYear;
    private String totalEditions;
}
