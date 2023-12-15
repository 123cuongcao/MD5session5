package ra.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.academy.dto.reponse.AuthorResponseDto;
import ra.academy.dto.request.AuthorRequestDto;
import ra.academy.entity.Author;
import ra.academy.repository.IAuthorRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AuthorService implements IAuthorService {
    private final IAuthorRepository iAuthorRepository;
    private final ModelMapper modelMapper;


    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {

        Author author = modelMapper.map(authorRequestDto, Author.class);
        AuthorResponseDto authorResponseDto = modelMapper.map(author,AuthorResponseDto.class);
        iAuthorRepository.save(author);
        return  authorResponseDto;
    }


    @Override
    public AuthorResponseDto getAuthor(Long id) throws NoSuchElementException {
        return modelMapper.map(iAuthorRepository.findById(id).orElseThrow(), AuthorResponseDto.class);
    }

    @Override
    public List<AuthorResponseDto> findAllAuthor() {
        return iAuthorRepository.findAll().stream()
                .map(a -> modelMapper.map(a, AuthorResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto deleteAuthor(Long id) {
       AuthorResponseDto authorResponseDto =  getAuthor(id);
      iAuthorRepository.delete(modelMapper.map(getAuthor(id),Author.class));
      return authorResponseDto;
    }

    @Override
    public AuthorResponseDto addZipcode(Long zipcodeId, Long authorId) {


        return null;
    }


}
