package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockBookService implements BookService {

    private List<Book> list;

    public MockBookService(List<Book> list) {
        this.list = list;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        return books;
    }

    public Optional<Book> get(Long id) {
        return Optional.empty();
    }

    public void add(Book book) {
    }

    public void delete(Long id) {
    }

    public void update(Book book) {
    }
}
