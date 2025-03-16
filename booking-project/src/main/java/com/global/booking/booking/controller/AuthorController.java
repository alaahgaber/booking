package com.global.booking.booking.controller;

import com.global.booking.booking.model.Author;
import com.global.booking.booking.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping("/{id}")
    public Author getById(@PathVariable long id){
        return service.getById(id);
    }

    @GetMapping("/count")
    public long getCount(){
        return service.getCount();
    }

    @GetMapping("/all")
    public List<Author> getAll(){
        return service.getAll();
    }

    @PostMapping("/insert")
    public Author insertNew(@RequestBody Author newauther){
        return service.insertNewAuthor(newauther);
    }

    @PutMapping("/update")
    public Author updateBook(@RequestBody Author editedauthor){
        return service.updateAuthor(editedauthor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable long id){
        service.deleteAuthor(id);
    }

    @PutMapping("/add/{id}/{bookid}")
    public void addBook(@PathVariable Long id, @PathVariable Long bookid){
        service.addBook(id,bookid);
    }

    @PutMapping("/remove")
    public void removeBook(@Param("id") Long id, @Param("bookid") Long bookid){
        service.removebooke(id,bookid);
    }

}
