package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(new ListResponse<AuthorEntity>(true, "Список авторов", authorService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BaseResponse> by_id(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<AuthorEntity>(true, "Найден следующий автор", authorService.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }

    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> save(@RequestBody AuthorEntity author) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AuthorEntity>(true, "Автор сохранен", authorService.save(author)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        try {
            authorService.update(author);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор сохранен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/del/{id}")//надо еще доделать удаление при условии, что айдишник существует, для этого использовать метод файндайди
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            authorService.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор удалён"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
}
