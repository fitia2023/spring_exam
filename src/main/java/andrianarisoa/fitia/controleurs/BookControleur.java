package andrianarisoa.fitia.controleurs;

import andrianarisoa.fitia.dto.BookDto;
import andrianarisoa.fitia.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookControleur {

    @Autowired
    private BookService bookService;

    /**  --Methodes pour CRUD-- **/
    @GetMapping("all")
    public List<BookDto> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public BookDto getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("add")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @PutMapping("up/{id}")
    public BookDto updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping("del/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
    }

    /**  --Methodes pour query-- **/
    @GetMapping("search/title/{title}")
    public List<BookDto> getBooksByTitle(@PathVariable("title") String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("search/bookafterdate/{date}")
    public List<BookDto> getBooksByPublishedDateAfter(@PathVariable("date") String date) throws ParseException {
        return bookService.getBooksByPublishedDateAfter(date);
    }
}
