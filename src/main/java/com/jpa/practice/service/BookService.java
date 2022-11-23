package com.jpa.practice.service;

import com.jpa.practice.domain.dto.BookResponseDto;
import com.jpa.practice.domain.entity.Author;
import com.jpa.practice.domain.entity.Book;
import com.jpa.practice.domain.entity.Publisher;
import com.jpa.practice.repository.AuthorRepository;
import com.jpa.practice.repository.BookRepository;
import com.jpa.practice.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookResponseDto> findAll() {
        List<Book> bookList = bookRepository.findAll();

        List<BookResponseDto> bookResponseList = new ArrayList<>();
        for (Book book:bookList) {
            Optional<Author> optAuthor = authorRepository.findById(book.getAuthor().getId());
            Optional<Publisher> optPublisher = publisherRepository.findById(book.getPublisher().getId());
            bookResponseList.add(new BookResponseDto(book.getId(), book.getName(), optAuthor.get().getName(), optPublisher.get().getName()));
        }
        return bookResponseList;
    }
}
