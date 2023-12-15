package ra.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.academy.dto.reponse.BookResponseDto;
import ra.academy.dto.request.BookRequestDto;
import ra.academy.entity.Book;

public interface IBookRepository extends JpaRepository<Book,Long> {

}
