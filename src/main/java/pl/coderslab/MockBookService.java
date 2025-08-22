package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {

    private List<Book> list = new ArrayList<>();

    public MockBookService(List<Book> list) {
        this.list = list;
    }


    // METHODS
    public List<Book> getBooks() {
        return this.list;
    }

    public Optional<Book> get(Long id) {
        for (Book item : list) {
            if (item.getId().equals(id)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public void add(Book book) {
        list.add(book);
    }

    public void delete(Long id) {
        for (Book item : list) {
            if (item.getId().equals(id)) {
                list.remove(item);
            }
        }
    }

    public void update(Book book) {
        Long bookId = book.getId();
        for (Book item : list) {
            if (item.getId().equals(bookId)) {
                item.setIsbn(book.getIsbn());
                item.setTitle(book.getTitle());
                item.setAuthor(book.getAuthor());
                item.setPublisher(book.getPublisher());
                item.setType(book.getType());
            }
        }
    }
}
