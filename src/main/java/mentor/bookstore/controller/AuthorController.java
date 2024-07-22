package mentor.bookstore.controller;

import lombok.RequiredArgsConstructor;
import mentor.bookstore.dto.requestdto.AuthorRequestDto;
import mentor.bookstore.dto.responsedto.AuthorResponseDto;
import mentor.bookstore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/create")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/getAll")
    public List<AuthorResponseDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/getId/{id}")
    public AuthorResponseDto getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/updateId/{id}")
    public AuthorResponseDto updateAuthor(@PathVariable Long id, @RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.updateAuthor(id, authorRequestDto);
    }

    @DeleteMapping("/deleteId/{id}")
    public AuthorResponseDto deleteAuthorById(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }
}
