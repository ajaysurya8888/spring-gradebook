package com.gradebook.Gradebook.data.service;

import com.gradebook.Gradebook.data.dto.DirectorDTO;
import com.gradebook.Gradebook.data.entity.Director;
import com.gradebook.Gradebook.data.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private final DirectorRepo directorRepo;

    public DirectorServiceImpl(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    @Override
    public Director save(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public void update(Director director) {
        directorRepo.save(director);
    }

    @Override
    public void delete(Long id) {
        directorRepo.deleteById(id);
    }

    @Override
    public Director getById(Long id) {
        return directorRepo.getById(id);
    }

    @Override
    public List<DirectorDTO> getAll() {
        List<DirectorDTO> directorDTOS = new ArrayList<>();

        directorRepo.findAll().forEach(director -> {
            directorDTOS.add(convertToDTO(director));
        });

        return directorDTOS;
    }

    @Override
    public DirectorDTO convertToDTO(Director director) {
        DirectorDTO directorDTO = new DirectorDTO();

        if (director != null) {
            directorDTO.setId(director.getId());
            directorDTO.setName(String.format("%s %s", director.getFirstName(), director.getSecondName()));
            directorDTO.setUsername(director.getUsername());
            directorDTO.setSchool("SCHOOL");
        }

        return directorDTO;
    }
}
