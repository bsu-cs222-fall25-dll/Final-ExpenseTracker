package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction();
        int amount = transaction.getAmount();
        Assertions.assertEquals(0, amount);
    }

    @Test
    public void testGetDescription() {}
}
