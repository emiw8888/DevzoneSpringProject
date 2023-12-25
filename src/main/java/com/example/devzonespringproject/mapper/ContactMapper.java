package com.example.devzonespringproject.mapper;

import com.example.devzonespringproject.dao.entity.ContactEntity;
import com.example.devzonespringproject.model.dto.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ContactMapper {
    public static ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    public abstract ContactDto mapEntityToDto(ContactEntity contactEntity);

    public abstract List<ContactDto> mapEntitiesToDtos(List<ContactEntity> contactEntities);
}
