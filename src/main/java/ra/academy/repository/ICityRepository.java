package ra.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.academy.entity.City;

public interface ICityRepository extends JpaRepository<City,Long> {
}
