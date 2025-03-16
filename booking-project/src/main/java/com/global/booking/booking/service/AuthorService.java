package com.global.booking.booking.service;

import com.global.booking.booking.model.Author;
import com.global.booking.booking.model.Book;
import com.global.booking.booking.reposotriy.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repo;

    @Autowired
    private BookService bookService;

    public long getCount(){
        return repo.count();
    }

    public Author getById(long id){
        return repo.findById(id).orElseThrow();
    }

    public List<Author> getAll(){
        return repo.findAll();
    }

    public Author insertNewAuthor(Author author){
        if(author.getId() != null){
             throw new RuntimeException();
        }
        return repo.save(author);
    }

    public List<Author> insertListOfAuthors(List<Author> authors){
        return repo.saveAll(authors);
    }

    public Author updateAuthor(Author author){
        Author editedauthor = getById(author.getId());
        editedauthor.setName(author.getName());
        return repo.save(editedauthor);
    }


    public void deleteAuthor(long id) {
        repo.deleteById(id);
    }

    @Transactional()
    @Modifying
    public void addBook(Long id, Long bookid){
        Author author = getById(id);
        Book book = bookService.getById(bookid);
        author.addBook(book);
        repo.save(author);
    }

    @Transactional()
    @Modifying
    public void removebooke(Long authotid, Long bookid){
        Author author = getById(authotid);
        Book book = bookService.getById(bookid);
        author.removeBook(book);
        repo.save(author);
    }

}
