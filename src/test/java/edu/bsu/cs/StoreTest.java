package edu.bsu.cs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

public class StoreTest {
    static Store store = new Store("./src/test/java/edu/bsu/cs/testStore.csv");

    @Test
    public void testAddTransaction() throws IOException {
        Transaction transaction = new Transaction(10.87F, Category.FOOD, "Spent on ice cream", LocalDate.now());
        store.addTransaction(transaction);
    }

    @Test
    public void testGetTransactions() throws IOException {
        testAddTransaction();
        Transaction transaction = store.getAllTransactions().getFirst();
        Assertions.assertEquals("Spent on ice cream", transaction.description());
    }

    @Test
    public void testRemoveTransaction() throws IOException {
        store.removeTransaction(0);
    }

    @AfterAll
    public static void cleanup() throws IOException {
        store.removeTransaction(0);
    }
}
