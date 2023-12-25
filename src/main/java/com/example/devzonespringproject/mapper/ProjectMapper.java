package com.example.devzonespringproject.mapper;

import com.example.devzonespringproject.dao.entity.ProjectEntity;
import com.example.devzonespringproject.model.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ProjectMapper {
    public static ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract ProjectEntity mapDtoToEntity(ProjectDto projectDto);

    @Mapping(target = "employee.projects", ignore = true)
    public abstract ProjectDto mapEntityToDto(ProjectEntity projectEntity);

    public abstract List<ProjectDto> mapEntitiesToDtos(List<ProjectEntity> projectEntities);
}
