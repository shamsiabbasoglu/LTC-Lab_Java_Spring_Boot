package mentor.bookstore.dto.responsedto;

import lombok.Getter;
import lombok.Setter;
import mentor.bookstore.entity.Author;

import java.util.List;

@Getter
@Setter
public class BookResponseDto {
    private Long id;
    private String title;
    private Double price;
    private Integer year;
    private Author author;
    private List<CategoryResponseDto> categories;
}
