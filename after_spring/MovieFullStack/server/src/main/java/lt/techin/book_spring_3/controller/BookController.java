package lt.techin.book_spring_3.controller;

import lt.techin.book_spring_3.exceptions.BookNotFoundException;
import lt.techin.book_spring_3.model.Book;
import lt.techin.book_spring_3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class BookController {
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<?> getBook(@PathVariable long id) {
    Optional<Book> book = bookService.getBookById(id);

    if (book.isEmpty()) {
      return ResponseEntity.badRequest().body("Book missing");
    }

    return ResponseEntity.ok(book.get());
  }

  @GetMapping("/books/search")
  public ResponseEntity<?> findBook(@RequestParam String title) {
    if (title.length() > 100) {
      return ResponseEntity.badRequest().body("Provided title is over 100 characters");
    }

    for (Book book : bookService.getAllBooks()) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return ResponseEntity.ok().body(book);
      }
    }

    return ResponseEntity.badRequest().body("Book not found...");
  }

  @PostMapping("/books")
  public ResponseEntity<?> addBook(@RequestBody Book book) {
    String title = book.getTitle();
    String author = book.getAuthor();
    String category = book.getCategory();
    String cover = book.getCover();
    BigDecimal price = book.getPrice();

    if (title == null || title.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Missing or empty title");
    }

    if (category == null || category.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Missing or empty category");
    }

    if (cover == null || cover.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Missing or empty cover");
    }

    if (price.compareTo(BigDecimal.valueOf(0)) < 0) {
      return ResponseEntity.badRequest().body("Invalid price");
    }

    if (title.length() > 100) {
      return ResponseEntity.badRequest().body("'Title' length is over 100 characters");
    }

    if (author != null && author.length() > 50) {
      return ResponseEntity.badRequest().body("'Author' length is over 50 characters");
    }

    Book savedBook = bookService.saveBook(book);

    // Nebutinas...
    if (savedBook != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book book) {
    Optional<Book> optionalBook = bookService.findBookById(id);
    String title = book.getTitle();
    String author = book.getAuthor();
    String category = book.getCategory();
    String cover = book.getCover();
    BigDecimal price = book.getPrice();
    boolean reserved = book.isReserved();

    if (title == null || title.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Missing or empty title");
    }

    if (category == null || category.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Missing or empty category");
    }

    if (cover == null || cover.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Missing or empty cover");
    }

    if (price.compareTo(BigDecimal.valueOf(0)) < 0) {
      return ResponseEntity.badRequest().body("Invalid price");
    }

    // If user does not give "reserved" field its auto false?
    if (!reserved) {
      return ResponseEntity.badRequest().body("Reserved status is required");
    }

    if (title.length() > 100) {
      return ResponseEntity.badRequest().body("'Title' length is over 100 characters");
    }

    if (author != null && author.length() > 50) {
      return ResponseEntity.badRequest().body("'Author' length is over 50 characters");
    }

    if (optionalBook.isPresent()) {
      Book bookToUpdate = optionalBook.get();

      bookToUpdate.setTitle(title);
      bookToUpdate.setAuthor(author);
      bookToUpdate.setCategory(category);
      bookToUpdate.setCover(cover);
      bookToUpdate.setPrice(price);
      bookToUpdate.setReserved(reserved);

      bookService.saveBook(bookToUpdate);
      return ResponseEntity.ok(bookToUpdate);
    } else {
      throw new BookNotFoundException("Book not found with id " + id);
    }
  }

  @PatchMapping("/books/{id}")
  public ResponseEntity<?> partialUpdateBook(@PathVariable long id, @RequestBody Book book) {
    Optional<Book> optionalBook = bookService.findBookById(id);

    if (optionalBook.isEmpty()) {
      throw new BookNotFoundException("Book not found with id " + id);
    }

    Book bookToUpdate = optionalBook.get();

    // Update fields only if they are provided
    if (book.getTitle() != null && !book.getTitle().trim().isEmpty()) {
      bookToUpdate.setTitle(book.getTitle());
    }
    if (book.getAuthor() != null && !book.getAuthor().trim().isEmpty()) {
      bookToUpdate.setAuthor(book.getAuthor());
    }
    if (book.getCategory() != null && !book.getCategory().trim().isEmpty()) {
      bookToUpdate.setCategory(book.getCategory());
    }
    if (book.getCover() != null && !book.getCover().trim().isEmpty()) {
      bookToUpdate.setCover(book.getCover());
    }
    if (book.getPrice() != null && book.getPrice().compareTo(BigDecimal.valueOf(0)) >= 0) {
      bookToUpdate.setPrice(book.getPrice());
    }

    bookToUpdate.setReserved(book.isReserved());

    // Validate that the price is valid (optional, if needed)
    if (bookToUpdate.getPrice() != null && bookToUpdate.getPrice().compareTo(BigDecimal.ZERO) < 0) {
      return ResponseEntity.badRequest().body("Invalid price");
    }

    // Save the updated book
    bookService.saveBook(bookToUpdate);

    return ResponseEntity.ok(bookToUpdate);
  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<?> deleteBook(@PathVariable long id) {
    Optional<Book> book = bookService.findBookById(id);

    if (book.isEmpty()) {
      return ResponseEntity.badRequest().body("Book does not exist");
    }

    bookService.deleteBookById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
