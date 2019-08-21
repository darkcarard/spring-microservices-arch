package co.ardicarl.bookapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ardicarl.bookapi.domain.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
