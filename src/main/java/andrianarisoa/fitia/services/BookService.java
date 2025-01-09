package andrianarisoa.fitia.services;

import andrianarisoa.fitia.dto.BookDto;
import andrianarisoa.fitia.model.BookModel;
import andrianarisoa.fitia.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**  --DTO en Model et Model en DTO-- **/
    private BookModel toBookModel(BookDto bookDto) {
        BookModel bookModel = new BookModel();
        bookModel.setId(bookDto.getId());
        bookModel.setTitle(bookDto.getTitle());
        bookModel.setAuthor(bookDto.getAuthor());
        bookModel.setIsbn(bookDto.getIsbn());
        bookModel.setPublishedDate(bookDto.getPublishedDate());
        bookModel.setStatus(bookDto.getStatus());
        return bookModel;
    }

    private BookDto toBookDto(BookModel bookModel) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookModel.getId());
        bookDto.setTitle(bookModel.getTitle());
        bookDto.setAuthor(bookModel.getAuthor());
        bookDto.setIsbn(bookModel.getIsbn());
        bookDto.setPublishedDate(bookModel.getPublishedDate());
        bookDto.setStatus(bookModel.getStatus());
        return bookDto;
    }

    /**  --Methodes pour obtenir CRUD-- **/

    public BookDto addBook(BookDto bookDto) {
        return toBookDto(bookRepository.save(toBookModel(bookDto)));
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book->toBookDto(book)).toList() ;
    }

    public BookDto getBookById(Long id) {
        return toBookDto(bookRepository.findById(id).orElse(null));
    }

    public BookDto updateBook(BookDto bookDto) {
        return toBookDto(bookRepository.save(toBookModel(bookDto)));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    /**  --Methodes pour query-- **/
    public List<BookDto> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(book->toBookDto(book)).toList() ;
    }

}
