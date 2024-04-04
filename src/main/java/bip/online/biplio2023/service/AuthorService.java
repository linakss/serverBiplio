package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.repository.AuthorRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import java.util.Optional;

@Service

@Validated
public class AuthorService {
    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }
    private final AuthorRepo repo;

    public List<AuthorEntity> findAll(){
        return repo.findAll();
    }
    public Optional<AuthorEntity> findById(Long id){
        return repo.findById(id);
    }
    public AuthorEntity save(@Valid AuthorEntity dataAuthor){
        return repo.save(dataAuthor);
    }
    public void update(@Valid AuthorEntity dataAuthor){
        repo.save(dataAuthor);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }

}
