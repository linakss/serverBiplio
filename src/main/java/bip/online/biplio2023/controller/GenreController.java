package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.CityService;
import bip.online.biplio2023.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/genre")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(
                    new ListResponse<GenreEntity>(true, "Список жанров:", genreService.findAll()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BaseResponse> by_id(@PathVariable Long id) {
        try{return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Найден следующий жанр:", genreService.findById(id).orElseThrow()));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
        }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> save(@RequestBody GenreEntity genre) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<GenreEntity>(true, "Жанр сохранен", genreService.save(genre)));
        } catch (RuntimeException e) {
        return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
    }
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody GenreEntity genre) {
        try{genreService.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Жанр изменен"));
    } catch (RuntimeException e) {
        return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
    }
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            genreService.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Жанр удалён"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
}
