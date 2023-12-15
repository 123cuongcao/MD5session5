package ra.academy.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.academy.entity.Book;
import ra.academy.entity.Zipcode;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private Long id;

    private String name;

    private Zipcode zipcode;

}
