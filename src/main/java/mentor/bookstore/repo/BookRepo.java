package mentor.bookstore.repo;

import mentor.bookstore.entity.Author;
import mentor.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);
}
