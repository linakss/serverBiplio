package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor

public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        try {
            return ResponseEntity.ok(
                    new ListResponse<BookEntity>(true, "Список книг:", bookService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BaseResponse> by_id(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<BookEntity>(true, "Найдена следующая книга:", bookService.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse> save(@RequestBody BookEntity book) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<BookEntity>(true, "Книга сохранена", bookService.save(book)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity book) {
        try {
            bookService.update(book);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Книга изменена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/del/{id}")
    //надо еще доделать удаление при условии, что айдишник существует, для этого использовать метод файндайди
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            bookService.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Книга удалена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }



@GetMapping("/findtitle/{title}")
    public ResponseEntity<BaseResponse> getTitle(@PathVariable String title){
        //try {
            return ResponseEntity.ok(new ListResponse(bookService.getTitle(title)));
        /*}catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }*/
      }
}