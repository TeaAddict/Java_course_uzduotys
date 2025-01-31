package lt.techin.book_spring_3.repository;

import lt.techin.book_spring_3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
