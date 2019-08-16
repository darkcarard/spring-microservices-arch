package co.ardicarl.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ardicarl.bookapi.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
