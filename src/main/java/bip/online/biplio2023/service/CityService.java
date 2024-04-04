package bip.online.biplio2023.service;
import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.repository.CityRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Validated
public class CityService {
    private final CityRepo repo;

    public List<CityEntity> findAll(){
        return repo.findAll();
    }
    public Optional<CityEntity> findById(Long id){
        return repo.findById(id);
    }
    public CityEntity save(@Valid CityEntity dataCity){
        return repo.save(dataCity);
    }
    public void update(@Valid CityEntity dataCity){
        repo.save(dataCity);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}