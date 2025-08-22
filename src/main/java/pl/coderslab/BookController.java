package pl.coderslab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    // pobieranie wszystkich dostępnych książek
    @RequestMapping("/books")
    public List<Book> showBooks() {
        return mockBookService.getBooks();
    }

    @RequestMapping("/addBook")
    public void addBook() {
        mockBookService.add(new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
    }
}

