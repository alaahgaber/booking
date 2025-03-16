package com.global.booking.booking.controller;

import com.global.booking.booking.model.Book;
import com.global.booking.booking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PutMapping("/updateprice")
    public int updateprice(@RequestParam(name = "price") double price, @RequestParam(name = "id") long id){
        return service.updateprice(price,id);
    }

    @GetMapping("/count")
    public long getCount(){
        return service.getCount();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable long id){
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return service.getAll();
    }

    @PostMapping("/insert")
    public Book insertNew(@RequestBody Book newbook){
       return service.insertNewBook(newbook);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book editedbook){
        return service.updateBook(editedbook);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable long id){
        service.deleteBook(id);
    }

    @PostMapping("/insertlist")
    public List<Book> insertList(@RequestBody List<Book> books){
        return service.insertListOfBook(books);
    }


}
