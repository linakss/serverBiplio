package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.repository.AuthorRepo;
import bip.online.biplio2023.repository.BookRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class BookService {
    private final BookRepo repo;
   public List<BookEntity> getTitle(String title){
        return repo.findByTitle(title);
    }

    public List<BookEntity> findAll(){
        return repo.findAll();
    }
    public Optional<BookEntity> findById(Long id){
        return repo.findById(id);
    }
    public BookEntity save(@Valid BookEntity dataBook){
        return repo.save(dataBook);
    }
    public void update(@Valid BookEntity dataBook){
        repo.save(dataBook);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
