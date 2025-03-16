package com.global.booking.booking.reposotriy;

import com.global.booking.booking.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepositroy extends JpaRepository<Book, Long> {


//    @Transactional: Ensures the method runs within a transaction.
//    @Modifying: Marks the query as one that modifies the database, so Spring handles it accordingly.
//    Both annotations are necessary to ensure the query executes correctly and the transaction is managed properly.

    @Transactional
    @Modifying
    @Query(value = "update books set price = :price where id = :id" , nativeQuery = true)
    public int updateprice(double price , long id);




//    @Override
//    @EntityGraph(attributePaths = {"author"})
//    Optional<Book> findById(Long aLong);
}
