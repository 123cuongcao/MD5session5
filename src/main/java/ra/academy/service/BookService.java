package ra.academy.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ra.academy.dto.reponse.BookResponseDto;
import ra.academy.dto.request.BookRequestDto;
import ra.academy.entity.Book;
import ra.academy.exception.NoIdException;
import ra.academy.repository.IBookRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository iBookRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        Book book = iBookRepository.save(modelMapper.map(bookRequestDto, Book.class));
        return modelMapper.map(book, BookResponseDto.class);
    }

    @Override
    public BookResponseDto findById(Long Id) throws NoSuchElementException {
        return modelMapper.map(iBookRepository.findById(Id).orElseThrow(), BookResponseDto.class);
    }

    @Override
    public List<BookResponseDto> findAll() {
        return iBookRepository.findAll().stream().map(a -> modelMapper.map(a, BookResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookResponseDto deleteBook(Long id) throws IllegalArgumentException, NoIdException, NoSuchElementException {
        if (iBookRepository.existsById(id)) {
            iBookRepository.deleteById(id);
            return modelMapper.map(iBookRepository.findById(id).orElseThrow(), BookResponseDto.class);
        }
        throw new NoIdException("ko tìm thấy đối tượng");
    }

}
