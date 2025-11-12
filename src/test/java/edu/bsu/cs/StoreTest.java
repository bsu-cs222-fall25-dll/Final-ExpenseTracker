package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {
    Store store = new Store("./testStore.csv");

    @Test
    public void testAddTransaction() { store.addTransaction(10, true, "Spent on ice cream"); }

    @Test
    public void testAddFloatTransaction() { store.addTransaction(4265.63F, true, "Spent on a shirt"); }

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
