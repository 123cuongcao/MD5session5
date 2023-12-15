package ra.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.academy.entity.Zipcode;

public interface IZipcodeRepository  extends JpaRepository<Zipcode,Long> {
}
