package com.maestro.expensetracker.controller;

import com.maestro.expensetracker.model.Expense;
import com.maestro.expensetracker.repository.ExpenseRepository;
import com.maestro.expensetracker.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Expense> getExpenseById(@PathVariable String id){
//        return ResponseEntity.ok(expenseService.getExpenseById(id));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
