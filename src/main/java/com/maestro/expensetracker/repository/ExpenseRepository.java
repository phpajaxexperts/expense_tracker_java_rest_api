package com.maestro.expensetracker.repository;

import com.maestro.expensetracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {


    //@Query("{'name': ?0, 'amount': ?1}")
    //Optional<Expense> findByName(String name, String amount);
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
