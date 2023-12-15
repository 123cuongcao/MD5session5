package ra.academy.dto.request;

import jakarta.persistence.*;
import ra.academy.entity.Author;
import ra.academy.entity.Category;

import java.util.List;

public class BookRequestDto {

    private String name;

    private List<Author> authors;

}
