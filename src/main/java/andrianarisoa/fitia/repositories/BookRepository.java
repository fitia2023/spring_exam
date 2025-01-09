package andrianarisoa.fitia.repositories;

import andrianarisoa.fitia.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    List<BookModel> findByTitle(String title);
}
