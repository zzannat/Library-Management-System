package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Book;
import com.repository.BookRepository;
import com.service.BookServiceImpl;

import reactor.core.publisher.Flux;


@SpringBootTest
class LibraryManagmentSystemApplicationTests {
	@Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testGetAll() {
        // Mocking repository response
        when(bookRepository.findAll()).thenReturn(Flux.just(new Book("Author", "Title", 10.0, 5)));

        // Call the service method
        Flux<Book> result = bookService.getAll();

        // Assert the result
        assertEquals(1, result.count().block());
    }


}
