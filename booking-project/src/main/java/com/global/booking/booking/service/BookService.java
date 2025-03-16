package com.global.booking.booking.service;

import com.global.booking.booking.model.Book;
import com.global.booking.booking.reposotriy.BookRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepositroy repo;


    public int updateprice(double price , long id){
        return repo.updateprice(price,id);
    }

    public long getCount(){
        return repo.count();
    }

    public Book getById(long id){
        return repo.findById(id).orElseThrow();
    }

//    public Book getById(long id){
//        return repo.getReferenceById(id);
//    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book insertNewBook(Book book){
        if(book.getId() != null){
            throw new RuntimeException();
        }
        return repo.save(book);
    }

    public List<Book> insertListOfBook(List<Book> books){
        return repo.saveAll(books);
    }

    public Book updateBook(Book book){
            Book editedbook = getById(book.getId());
            editedbook.setTitle(book.getTitle());
            editedbook.setAuthor(book.getAuthor());
            editedbook.setPrice(book.getPrice());
        return repo.save(editedbook);
    }

    public void deleteBook(long id){
        repo.deleteById(id);
    }

}
