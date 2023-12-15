package ra.academy.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.academy.dto.request.AuthorRequestDto;
import ra.academy.dto.reponse.AuthorResponseDto;
import ra.academy.entity.Author;
import ra.academy.entity.Zipcode;
import ra.academy.repository.IAuthorRepository;
import ra.academy.service.IAuthorService;

import java.util.List;

@RestController
@RequestMapping(value = "practice/api/v1")
@RequiredArgsConstructor
public class AuthorController {
    private final IAuthorService iAuthorService;
    private final IAuthorRepository iAuthorRepository;
    private final ModelMapper modelMapper;


    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return new ResponseEntity<>(iAuthorService.addAuthor(authorRequestDto), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable Long id) {

        return new ResponseEntity<>(iAuthorService.getAuthor(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors() {
        return new ResponseEntity<>(iAuthorService.findAllAuthor(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable Long id) {
        return new ResponseEntity<>(iAuthorService.deleteAuthor(id), HttpStatus.OK);
    }


    @PostMapping("/edit/{id}")
    private ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable Long id,
                                                         @RequestBody AuthorRequestDto authorRequestDto) {
        authorRequestDto.setId(id);
        return new ResponseEntity<>(iAuthorService.addAuthor(authorRequestDto), HttpStatus.OK);
    }

    @PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
    private ResponseEntity<AuthorResponseDto> addZipcode(@PathVariable Zipcode zipcodeId,
                                                         @PathVariable Author authorId) {

        authorId.setZipcode(zipcodeId);

        iAuthorService.addAuthor(modelMapper.map(iAuthorService.getAuthor(authorId.getId()), AuthorRequestDto.class));

        return new ResponseEntity<>(iAuthorService.addAuthor(modelMapper.map(iAuthorService.getAuthor(authorId.getId()), AuthorRequestDto.class)), HttpStatus.OK);
    }

    @PostMapping("/removeZipcode/{id}")
    private ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable("id")  Author author) {
        author.setZipcode(null);
        iAuthorService.addAuthor(modelMapper.map(author,AuthorRequestDto.class));
        return new ResponseEntity<>( iAuthorService.addAuthor(modelMapper.map(author,AuthorRequestDto.class)),HttpStatus.OK);
    }



}
