package com.example.devzonespringproject.mapper;

import com.example.devzonespringproject.dao.entity.BookEntity;
import com.example.devzonespringproject.model.dto.BookDto;

import java.util.List;

public class BookMapper {
    public static BookDto mapEntityToDto(BookEntity bookEntity) {
        return BookDto.builder()
            .id(bookEntity.getId())
            .name(bookEntity.getName())
            .price(bookEntity.getPrice())
            .build();
    }

    public static BookEntity mapDtoToEntity(BookDto bookDto) {
        return BookEntity.builder()
            .name(bookDto.getName())
            .price(bookDto.getPrice())
            .build();
    }

    public static List<BookDto> mapEntitiesToDtos(List<BookEntity> bookEntities) {
        return bookEntities
            .stream()
            .map(BookMapper::mapEntityToDto)
            .toList();
    }


    public static BookEntity editBookEntity(BookDto bookDto, BookEntity bookEntity) {
        bookEntity.setName(bookDto.getName());
        bookEntity.setPrice(bookDto.getPrice());
        return bookEntity;
    }
}
