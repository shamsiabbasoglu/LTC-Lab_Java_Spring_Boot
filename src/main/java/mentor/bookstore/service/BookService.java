package mentor.bookstore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentor.bookstore.dto.responsedto.BookResponseDto;
import mentor.bookstore.entity.Author;
import mentor.bookstore.entity.Book;
import mentor.bookstore.repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;
    private final List<Book> books;

    public BookResponseDto createBook(BookResponseDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        books.add(book);
        return modelMapper.map(bookRepo.save(book), BookResponseDto.class);
    }

    public List<BookResponseDto> getAllBooks() {
        List<Book> bookEntities = bookRepo.findAll();
        return bookEntities.stream()
                .map(entity -> modelMapper.map(entity, BookResponseDto.class))
                .toList();
    }

    public BookResponseDto findBookById(Long id) {
        Book bookEntity = bookRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        return modelMapper.map(bookEntity, BookResponseDto.class);
    }

    public List<BookResponseDto> findBookByAuthor(Author author) {
        List<Book> bookEntities = bookRepo.findAllByAuthor(author);
        return bookEntities.stream()
                .map(entity -> modelMapper.map(entity, BookResponseDto.class))
                .toList();
    }

    public BookResponseDto updateBook(Long id, BookResponseDto book) {
        Book bookEntity = bookRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        modelMapper.map(book, bookEntity);
        return modelMapper.map(bookRepo.save(bookEntity), BookResponseDto.class);
    }

    public BookResponseDto deleteBook(Long id) {
        Book bookEntity = bookRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        bookRepo.delete(bookEntity);
        return modelMapper.map(bookEntity, BookResponseDto.class);
    }

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.HOURS)
    private void execute() {
        if (!books.isEmpty()) {
            System.out.println("Books added at last 60 minutes: ");
            books.forEach(System.out::println);
            books.clear();
            System.out.println("\nLastly added books were deleted.");
        } else {
            log.info("No books were added at last 60 minutes!");
        }
    }
}
