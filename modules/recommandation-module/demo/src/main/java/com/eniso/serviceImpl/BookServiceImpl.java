package com.eniso.serviceImpl;

import com.eniso.payloads.BookRequest;
import com.eniso.entities.Book;
import com.eniso.repositories.BookRepository;
import com.eniso.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void saveBook(BookRequest bookRequest) {

        Book book = new Book();
        book.setName(bookRequest.getTitle());
        book.setIsbn(bookRequest.getTitle());

        bookRepository.save(
            book
        );
    }
}
