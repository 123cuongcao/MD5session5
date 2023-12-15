package ra.academy.dto.reponse;

import jakarta.persistence.*;
import ra.academy.entity.Author;
import ra.academy.entity.Category;

import java.util.List;

public class BookResponseDto {
    
    private String name;
    List<Category> categories;
    private List<Author> authors ;

}
