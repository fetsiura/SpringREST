package pl.jaro.web;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.jaro.model.Book;
import pl.jaro.service.BookService;
import pl.jaro.service.MockBookService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
       log.info(bookService.getBooks().toString());
        return bookService.getBooks();
    }










    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }




}
