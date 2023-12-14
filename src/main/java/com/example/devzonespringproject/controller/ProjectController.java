package com.example.devzonespringproject.controller;

import com.example.devzonespringproject.model.dto.ProjectDto;
import com.example.devzonespringproject.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDto> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public ProjectDto getProject(Long id) {
        return projectService.getProject(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProject(@RequestBody ProjectDto projectDto) {
        projectService.addProject(projectDto);
    }

    @PutMapping("/{id}")
    public void editProject(@RequestBody ProjectDto projectDto,
                            @PathVariable Long id) {
        projectService.editProject(projectDto, id);

    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
