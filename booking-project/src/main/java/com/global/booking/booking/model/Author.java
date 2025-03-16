package com.global.booking.booking.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.add(book);
    }




    //    @Formula("(select count(*) from books b where b.author_id = id)")
//    @JsonProperty("bookcount")
//    private int bookcount;
//    @Formula("(select group_concat(b.title) from books b where b.author_id = id)")
//    @JsonProperty("booksname")
//    private String booksname;

}
