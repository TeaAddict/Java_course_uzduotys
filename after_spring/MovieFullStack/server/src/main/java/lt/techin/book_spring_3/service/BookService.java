package lt.techin.book_spring_3.service;

import lt.techin.book_spring_3.model.Book;
import lt.techin.book_spring_3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Optional<Book> getBookById(long id) {
    return bookRepository.findById(id);
  }

  public boolean existsBookById(long id) {
    return bookRepository.existsById(id);
  }

  public Optional<Book> findBookById(long id) {
    return bookRepository.findById(id);
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public void deleteBookById(long id) {
    bookRepository.deleteById(id);
  }


}
