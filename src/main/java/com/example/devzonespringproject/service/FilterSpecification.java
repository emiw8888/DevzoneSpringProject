package com.example.devzonespringproject.service;

import com.example.devzonespringproject.model.dto.SearchDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class FilterSpecification<T> {
    public Specification<T> getSpecification(SearchDto searchDto) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get(searchDto.getColumn()),
                "%" + searchDto.getValue() + "%");
    }
}
