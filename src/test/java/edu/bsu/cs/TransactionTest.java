package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction(200, true, "Spent on ice cream");
        float amount = transaction.amount();
        Assertions.assertEquals(200, amount);
    }

    @Test
    public void testGetDescription() {
        Transaction transaction = new Transaction(200, false, "Spent on ice cream");
        String description = transaction.description();
        Assertions.assertEquals("Spent on ice cream", description);
    }
}
