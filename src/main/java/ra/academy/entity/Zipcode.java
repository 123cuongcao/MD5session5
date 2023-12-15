package ra.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(length = 20)
    private String name;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "zipcode")
    private List<Author> authors;


}
