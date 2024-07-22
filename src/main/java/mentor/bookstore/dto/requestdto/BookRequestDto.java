package mentor.bookstore.dto.requestdto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookRequestDto {
    private String title;
    private Double price;
    private Integer year;
    private Long authorId;
    private List<Long> categoryIds;
}
