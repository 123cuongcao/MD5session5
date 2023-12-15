package ra.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.academy.dto.reponse.BookResponseDto;
import ra.academy.dto.request.BookRequestDto;
import ra.academy.entity.Book;
import ra.academy.exception.NoIdException;
import ra.academy.repository.IBookRepository;
import ra.academy.service.IBookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final IBookService iBookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto) {
        iBookService.save(bookRequestDto);
        return new ResponseEntity<>(iBookService.save(bookRequestDto), HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(iBookService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getBooks() {
        return new ResponseEntity<>(iBookService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable Long id) throws NoIdException {
        return new ResponseEntity<>(iBookService.deleteBook(id), HttpStatus.OK);
    }


}
