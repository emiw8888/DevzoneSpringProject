package com.example.devzonespringproject.service;

import com.example.devzonespringproject.dao.entity.BookEntity;
import com.example.devzonespringproject.dao.repository.BookRepository;
import com.example.devzonespringproject.mapper.BookMapper;
import com.example.devzonespringproject.model.dto.BookDto;
import com.example.devzonespringproject.model.dto.SearchDto;
import com.example.devzonespringproject.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    BookRepository bookRepository;
    FilterSpecification<BookEntity> filterSpecification;

    public BookService(BookRepository bookRepository, FilterSpecification<BookEntity> filterSpecification) {
        this.bookRepository = bookRepository;
        this.filterSpecification = filterSpecification;
    }

    public List<BookDto> getBooks(Integer pageNo, Integer pageSize) {
        log.info("ActionLog.getBooks.start");
        List<BookEntity> bookEntities = bookRepository
            .findAll(PageRequest.of(pageNo, pageSize))
            .getContent();
        log.info("ActionLog.getBooks.end");
        return BookMapper.INSTANCE.mapEntitiesToDtos(bookEntities);
    }

    public List<BookDto> searchBooks(SearchDto searchDto) {
        log.info("ActionLog.searchBooks.start");
        Specification<BookEntity> specification = filterSpecification.getSpecification(searchDto);
        List<BookEntity> bookEntities = bookRepository.findAll(specification);
        log.info("ActionLog.searchBooks.end");
        return BookMapper.INSTANCE.mapEntitiesToDtos(bookEntities);

    }

    public BookDto getBook(Long id) {
        log.info("ActionLog.getBook.start");
        BookEntity bookEntity = getBookIfExist(id);
        log.info("ActionLog.getBook.end");
        return BookMapper.INSTANCE.mapEntityToDto(bookEntity);
    }

    public void addBook(BookDto bookDto) {
        log.info("ActionLog.addBook.start");
        bookRepository.save(BookMapper.INSTANCE.mapDtoToEntity(bookDto));
        log.info("ActionLog.addBook.end");
    }

    public void editBook(Long id, BookDto bookDto) {
        log.info("ActionLog.editBook.start");
        bookRepository.save(
            BookMapper.editBookEntity(bookDto, getBookIfExist(id))
        );
        log.info("ActionLog.editBook.end");
    }

    private BookEntity getBookIfExist(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> {
                throw new NotFoundException("BOOK_NOT_FOUND");
            });
    }
}
