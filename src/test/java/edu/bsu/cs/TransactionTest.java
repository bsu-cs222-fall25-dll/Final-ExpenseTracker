package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransactionTest {

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction(200, Category.FOOD, "Spent on ice cream", LocalDate.now());
        float amount = transaction.amount();
        Assertions.assertEquals(200, amount);
    }

    @Test
    public void testGetDescription() {
        Transaction transaction = new Transaction(200, Category.FOOD, "Spent on ice cream", LocalDate.now());
        String description = transaction.description();
        Assertions.assertEquals("Spent on ice cream", description);
    }

    @Test
    public void testGetCategory() {
        Transaction transaction = new Transaction(200, Category.FOOD, "Spent on ice cream", LocalDate.now());
        Category category = transaction.category();
        Assertions.assertEquals(Category.FOOD, category);
    }
}
