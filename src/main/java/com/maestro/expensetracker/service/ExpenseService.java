package com.maestro.expensetracker.service;

import com.maestro.expensetracker.model.Expense;
import com.maestro.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Expense By ID %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannont find expense by name %s", name)));
    }

    public Expense getExpenseById(String id){
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannont find expense by id %s", id)));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
