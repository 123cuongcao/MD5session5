package ra.academy.service;

import ra.academy.dto.reponse.AuthorResponseDto;
import ra.academy.dto.request.AuthorRequestDto;
import ra.academy.entity.Author;

import java.util.List;

public interface IAuthorService  {
    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);

    AuthorResponseDto getAuthor(Long id);

    List<AuthorResponseDto> findAllAuthor();

    AuthorResponseDto deleteAuthor(Long id);

    AuthorResponseDto addZipcode(Long zipcodeId ,Long authorId);
}
