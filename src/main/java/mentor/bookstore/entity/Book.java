package mentor.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_price")
    private Double price;

    @Column(name = "book_year")
    private Integer year;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private List<Category> categories;
}