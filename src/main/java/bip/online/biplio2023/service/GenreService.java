package bip.online.biplio2023.service;
import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.repository.GenreRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Validated
public class GenreService {
    private final GenreRepo repo;

    public List<GenreEntity> findAll(){
        return repo.findAll();
    }
    public Optional<GenreEntity> findById(Long id){
        return repo.findById(id);
    }
    public GenreEntity save(@Valid GenreEntity dataGenre){
        return repo.save(dataGenre);
    }
    public void update(@Valid GenreEntity dataGenre){
        repo.save(dataGenre);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}