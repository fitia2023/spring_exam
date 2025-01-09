package andrianarisoa.fitia.dto;

import andrianarisoa.fitia.model.STATUSBOOK;

import java.util.Date;

public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Date publishedDate;
    private STATUSBOOK status;

    /**  --Getters ainsi que les Setters-- **/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public STATUSBOOK getStatus() {
        return status;
    }

    public void setStatus(STATUSBOOK status) {
        this.status = status;
    }
}
