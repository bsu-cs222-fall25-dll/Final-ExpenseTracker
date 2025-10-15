package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpenseTest {


    @Test
    public void testTotalAmount() {
        Expense expense = new Expense();
        int totalExpense = expense.getTotalAmount();
        Assertions.assertEquals(0, totalExpense);
    }
}
