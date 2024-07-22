package mentor.bookstore.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<BookResponseDto> books;
}
