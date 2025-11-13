package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {
    Store store = new Store("./testStore.csv");

    @Test
    public void testAddTransaction() {
        Transaction transaction = new Transaction(10.87F, true, "Spent on ice cream");
        store.addTransaction(transaction);
    }

    @Test
    public void testGetAmountTransaction() {
        testAddTransaction();
        Transaction transaction = store.getTransaction(0);
        Assertions.assertEquals(10, transaction.amount());
    }

    @Test
    public void testGetDescriptionTransaction() {
        testAddTransaction();
        Transaction transaction = store.getTransaction(0);
        Assertions.assertEquals("Spent on ice cream", transaction.description());
    }

    @Test
    public void testRemoveTransaction() {
        testAddTransaction();
        store.removeTransaction(0);
    }
}
