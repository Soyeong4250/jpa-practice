package com.jpa.practice.controller;

import com.jpa.practice.domain.dto.BookResponseDto;
import com.jpa.practice.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "도서 전체 리스트 조회", notes = "GET Method")
    @GetMapping()
    public ResponseEntity<List<BookResponseDto>> findAll() {
       List<BookResponseDto> bookList = bookService.findAll();
       return ResponseEntity.ok().body(bookList);
    }

}
