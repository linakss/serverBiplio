package bip.online.biplio2023.service;
import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.repository.PublishRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Validated
@Getter
public class PublishService {
    private final PublishRepo repo;

    public List<PublisherEntity> findAll(){
        return repo.findAll();
    }

    public Optional<PublisherEntity> findById(Long id){
        return repo.findById(id);
    }
    public PublisherEntity save(@Valid PublisherEntity dataPublish){
        return repo.save(dataPublish);
    }
    public void update(@Valid PublisherEntity dataPublish){
        repo.save(dataPublish);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}

