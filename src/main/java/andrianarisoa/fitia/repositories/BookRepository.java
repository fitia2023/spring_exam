package andrianarisoa.fitia.repositories;

import andrianarisoa.fitia.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}
