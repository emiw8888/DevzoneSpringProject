package com.example.devzonespringproject.service;

import com.example.devzonespringproject.dao.entity.BookEntity;
import com.example.devzonespringproject.dao.repository.BookRepository;
import com.example.devzonespringproject.mapper.BookMapper;
import com.example.devzonespringproject.model.dto.BookDto;
import com.example.devzonespringproject.model.exception.BookNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getBooks(Integer pageNo, Integer pageSize) {
        return BookMapper.mapEntitiesToDtos(bookRepository
            .findAll(PageRequest.of(pageNo, pageSize))
            .getContent());
    }

    public BookDto getBook(Long id) {
        return BookMapper.mapEntityToDto(getBookIfExist(id));
    }

    public void addBook(BookDto bookDto) {
        bookRepository.save(BookMapper.mapDtoToEntity(bookDto));
    }

    public void editBook(Long id, BookDto bookDto) {
        bookRepository.save(
            BookMapper.editBookEntity(bookDto, getBookIfExist(id))
        );
    }

    private BookEntity getBookIfExist(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> {
                throw new BookNotFoundException("BOOK_NOT_FOUND");
            });
    }
}
