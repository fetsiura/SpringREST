package pl.jaro.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.jaro.model.Book;
import pl.jaro.service.BookService;

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


    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }


    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){

       return bookService.get(id).orElseThrow( () -> {
           throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "book does not found");
       });
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }


    @PutMapping
    public void updateBook(@RequestBody Book book){
        bookService.update(book);
    }


////////////////////////
    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }




}
