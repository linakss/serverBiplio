package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.PublishService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publish")
@AllArgsConstructor
public class PublishController {


    private final PublishService publishService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(
                    new ListResponse<PublisherEntity>(true, "Список издательств:", publishService.findAll()));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BaseResponse> by_id(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<PublisherEntity>(true, "Найдено следующее издательство:", publishService.findById(id).orElseThrow()));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }



    @PostMapping("/save")
    public ResponseEntity<BaseResponse> save(@RequestBody PublisherEntity publish) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<PublisherEntity>(true, "Издательство сохранено", publishService.save(publish)));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity publish) {
        try {
            publishService.update(publish);
            return ResponseEntity.ok(
                new BaseResponse(true, "Издательство сохранено"));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            publishService.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Издательство удалено"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }
}
