package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/city")
@AllArgsConstructor
public class CityController {
        private final CityService cityService;

        @GetMapping("/all")
        public ResponseEntity<BaseResponse> getAll() {
            try {
                return ResponseEntity.ok(
                        new ListResponse<CityEntity>(true, "Список городов:", cityService.findAll()));
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
            }
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<BaseResponse> by_id(@PathVariable Long id) {
            try{return ResponseEntity.ok(
                    new DataResponse<CityEntity>(true, "Найден следующий город:", cityService.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
        return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
    }}

        @PostMapping("/save")
        public ResponseEntity<BaseResponse> save(@RequestBody CityEntity city) {
            try {return ResponseEntity.ok(
                    new DataResponse<CityEntity>(true, "Город сохранен", cityService.save(city)));
        } catch (RuntimeException e) {
        return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
    }}

        @PutMapping("/update")
        public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
            try{cityService.update(city);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Город изменен"));
        } catch (RuntimeException e) {
        return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
    }
        }
        @DeleteMapping("/del/{id}")//надо еще доделать удаление при условии, что айдишник существует, для этого использовать метод файндайди
        public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
            try {
                cityService.delete(id);
                return ResponseEntity.ok(
                        new BaseResponse(true, "Город удалён"));
            } catch (RuntimeException e) {
                return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
            }
        }
    }