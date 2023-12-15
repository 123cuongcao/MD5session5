package ra.academy.dto.reponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.academy.entity.Zipcode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {

    private String name;
    @JsonIgnore()
    private Zipcode zipcode;

}
