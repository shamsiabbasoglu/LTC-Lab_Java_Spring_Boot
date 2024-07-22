package mentor.bookstore.controller;

import lombok.RequiredArgsConstructor;
import mentor.bookstore.dto.responsedto.BookResponseDto;
import mentor.bookstore.entity.Author;
import mentor.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public BookResponseDto add(@RequestBody BookResponseDto book) {
        return bookService.createBook(book);
    }

    @GetMapping("/getAll")
    public List<BookResponseDto> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/findId/{id}")
    public BookResponseDto findById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/findAuthor/{author}")
    public List<BookResponseDto> findByAuthor(@PathVariable Author author) {
        return bookService.findBookByAuthor(author);
    }

    @PutMapping("/updateId/{id}")
    public BookResponseDto update(@PathVariable Long id, @RequestBody BookResponseDto book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/deleteId/{id}")
    public BookResponseDto delete(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}