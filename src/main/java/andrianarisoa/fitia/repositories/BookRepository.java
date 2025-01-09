package andrianarisoa.fitia.repositories;

import andrianarisoa.fitia.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    List<BookModel> findByTitle(String title);

    @Query("SELECT b FROM BookModel b WHERE b.publishedDate > :datebefore")
    List<BookModel> findBookByPublishedDateAfter(@Param("datebefore") Date datebefore);

}
