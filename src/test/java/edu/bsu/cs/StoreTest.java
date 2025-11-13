package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {
    Store store = new Store("./src/test/java/edu/bsu/cs/testStore.csv");

    @Test
    public void testAddTransaction() {
        Transaction transaction = new Transaction(10.87F, true, "Spent on ice cream");
        store.addTransaction(transaction);
    }

    @Test
    public void testGetTransactions() {
        testAddTransaction();
        Transaction transaction = store.getAllTransactions().getFirst();
        Assertions.assertEquals("Spent on ice cream", transaction.description());
    }

    @Test
    public void testRemoveTransaction() {
        store.removeTransaction(0);
    }
}
