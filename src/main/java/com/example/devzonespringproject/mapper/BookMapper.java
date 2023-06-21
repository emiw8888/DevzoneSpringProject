package com.example.devzonespringproject.mapper;

import com.example.devzonespringproject.dao.entity.BookEntity;
import com.example.devzonespringproject.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class BookMapper {
    public static BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    public abstract BookDto mapEntityToDto(BookEntity bookEntity);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract BookEntity mapDtoToEntity(BookDto bookDto);

    public abstract List<BookDto> mapEntitiesToDtos(List<BookEntity> bookEntities);


    public static BookEntity editBookEntity(BookDto bookDto, BookEntity bookEntity) {
        bookEntity.setName(bookDto.getName());
        bookEntity.setPrice(bookDto.getPrice());
        return bookEntity;
    }
}
