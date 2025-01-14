package com.eniso.services;


import com.eniso.payloads.BookRequest;
import org.springframework.stereotype.Service;

@Service("bookService")
public interface BookService {
    void saveBook(BookRequest bookRequest);
}
