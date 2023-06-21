package com.example.devzonespringproject.service;

import com.example.devzonespringproject.dao.entity.ProjectEntity;
import com.example.devzonespringproject.dao.repository.ProjectRepository;
import com.example.devzonespringproject.mapper.ProjectMapper;
import com.example.devzonespringproject.model.dto.ProjectDto;
import com.example.devzonespringproject.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDto> getProjects() {
        log.info("ActionLog.getProjects.start");
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        log.info("ActionLog.getProjects.end");
        return ProjectMapper.INSTANCE.mapEntitiesToDtos(projectEntities);
    }

    public ProjectDto getProject(Long id) {
        log.info("ActionLog.getProject.start with id: {}", id);
        ProjectEntity project = getProjectIfExist(id);
        log.info("ActionLog.getProject.end with id: {}", id);
        return ProjectMapper.INSTANCE.mapEntityToDto(project);
    }

    public void addProject(ProjectDto projectDto) {
        log.info("ActionLog.addProject.start");
        projectRepository.save(ProjectMapper.INSTANCE.mapDtoToEntity(projectDto));
        log.info("ActionLog.addProject.end");
    }

    public void editProject(ProjectDto projectDto, Long id) {
        log.info("ActionLog.editProject.start with id: {}", id);
        projectRepository.update(projectDto.getName(), projectDto.getEmployee().getId(), id);
        log.info("ActionLog.editProject.end with id: {}", id);
    }

    public void deleteProject(Long id) {
        log.info("ActionLog.deleteProject.start with id: {}", id);
        projectRepository.deleteById(id);
        log.info("ActionLog.deleteProject.end with id: {}", id);
    }

    private ProjectEntity getProjectIfExist(Long id) {
        return projectRepository.findById(id).orElseThrow(
            () -> {
                log.error("ActionLog.projectNotFound.withId: {}", id);
                throw new NotFoundException("PROJECT_NOT_FOUND");
            }
        );
    }
}
