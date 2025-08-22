package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController {
    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }


    // lista wszystkich dostępnych książek
    @RequestMapping("/books")
    public List<Book> showBooks() {
        return mockBookService.getBooks();
    }

    // dodawanie książki
    @PostMapping("/books")
    public String addBook(@RequestBody Book bookToAdd) {
        mockBookService.add(bookToAdd);
        return "Book added";
    }

    // wyświetlanie info o książce o podanym id
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id) {

        return mockBookService.get(id);
    }

    // zmiana info o książce
    @PutMapping("/books")
    public String updateBook(@RequestBody Book bookToUpdate) {
        mockBookService.update(bookToUpdate);
        return "Book updated";
    }

    //usuwanie książki
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        mockBookService.delete(id);
        return "Book deleted";
    }

}

