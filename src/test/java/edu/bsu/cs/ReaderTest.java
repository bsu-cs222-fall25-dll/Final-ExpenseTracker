package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ReaderTest {
    Reader reader = new Reader("./testStore.csv");

    @Test
    public void testSaveAllTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(42.4F, true, "ice cream"));
        reader.saveAllTransactions(transactions);

        Assertions.assertEquals(reader.loadAllTransactions(), transactions);
    }

    @Test
    public void testLoadAllTransactions() {
        ArrayList<Transaction> transactions = reader.loadAllTransactions();
        Assertions.assertEquals("ice cream", transactions.get(0).description());
    }
}
