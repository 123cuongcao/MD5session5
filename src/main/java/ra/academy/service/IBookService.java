package ra.academy.service;

import ra.academy.dto.reponse.BookResponseDto;
import ra.academy.dto.request.BookRequestDto;
import ra.academy.exception.NoIdException;

import java.util.List;

public interface IBookService {
    BookResponseDto save(BookRequestDto bookRequestDto);
    BookResponseDto findById(Long Id);
    List<BookResponseDto> findAll();
    BookResponseDto deleteBook(Long id) throws NoIdException;
}
