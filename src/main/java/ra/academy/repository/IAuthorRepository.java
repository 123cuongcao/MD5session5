package ra.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.academy.entity.Author;

public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
