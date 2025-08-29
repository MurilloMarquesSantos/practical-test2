package dev.marques.practicaltest2.controller;

import dev.marques.practicaltest2.dto.BookDto;
import dev.marques.practicaltest2.dto.PagedResponse;
import dev.marques.practicaltest2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/comics")
    public ResponseEntity<PagedResponse<BookDto>> comics(@RequestParam(defaultValue = "1") int page,
                                                         @RequestParam(defaultValue = "20") int size,
                                                         @RequestParam(defaultValue = "true") boolean sortAsc) {
        return ResponseEntity.ok(bookService.searchBySubject("comics", page, size, sortAsc));

    }

    @GetMapping("/movies")
    public PagedResponse<BookDto> movies(
            @RequestParam String name,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "true") boolean sortAsc) {
        return bookService.searchByTitle(name + " movie", page, size, sortAsc);
    }

    @GetMapping("/superheroes")
    public PagedResponse<BookDto> superheroes(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "true") boolean sortAsc) {
        return bookService.searchBySubject("superheroes", page, size, sortAsc);
    }

}
