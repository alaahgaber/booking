
package com.global.booking.booking;

import com.global.booking.booking.model.Author;
import com.global.booking.booking.model.Book;
import com.global.booking.booking.service.AuthorService;
import com.global.booking.booking.service.BookService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class AppConfigStart implements CommandLineRunner {

    @Autowired
    private BookService bookservice;
    @Autowired
    private AuthorService authorservice;


    @PostConstruct
    public void init() {
        System.out.println("AppConfigStart initialized...");
    }


    @Override
    @Transactional()
    public void run(String... args) throws Exception {

        System.out.println("AppConfigStart is running...");

        if(authorservice.getCount() == 0 || bookservice.getCount() == 0) {


            List<String> names = List.of("Amr", "Emad", "Alaa","Eslam");

            List<Author> authors = names.stream()
                                        .map(name -> {
                                            Author author = new Author();
                                            author.setName(name);
                                            return author;
                                            }
                                        ).collect(Collectors.toList());




//            List<Author> authors = new ArrayList<>();
//
//            for (String name : names) {
//                Author author = new Author();
//                author.setName(name);
//                authors.add(author);
//            }
//

            authorservice.insertListOfAuthors(authors);


            List<String> titles = List.of("Linux Administrator", "Chicken farming", "VFX artist", "Happy Life", "Java Data Structure");
            List<Double> price = List.of(600.5, 165.87, 554.25, 305.498, 1897.55);
            List<Long> authorid = List.of(1L, 2L, 1L, 2L, 3L);
            List<Book> books = new ArrayList<>();

            for (int i = 0; i < titles.size(); i++) {
                Book book = new Book();
                book.setTitle(titles.get(i));
                book.setPrice(price.get(i));
                book.setAuthor(authorservice.getById(authorid.get(i)));
                books.add(book);
            }

            bookservice.insertListOfBook(books);


        }


    }
}
