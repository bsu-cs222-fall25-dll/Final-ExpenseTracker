package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {
    Store store = new Store();

    @Test
    public void testAddTransaction() { store.addTransaction(0, true, "Spent on ice cream"); }

    @Test
    public void testGetTransaction() {
        testAddTransaction();
        Transaction transaction = store.getTransaction(0);
        Assertions.assertEquals(0, transaction.amount());
        Assertions.assertEquals("Spent on ice cream", transaction.description());
    }
}
