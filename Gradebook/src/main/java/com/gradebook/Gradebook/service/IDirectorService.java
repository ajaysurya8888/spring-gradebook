package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.entity.Director;

import java.util.List;

public interface IDirectorService {
    Director save(Director director);
    void update(Director director);
    void delete(Long id);
    Director getById(Long id);
    List<DirectorDTO> getAll();

    DirectorDTO convertToDTO(Director director);
}