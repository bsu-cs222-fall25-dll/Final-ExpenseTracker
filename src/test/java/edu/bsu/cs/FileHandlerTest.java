package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FileHandlerTest {
    FileHandler fileHandler = new FileHandler("./src/test/java/edu/bsu/cs/testStore.csv");

    @Test
    public void testSaveAllTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(42.4F, true, "ice cream"));
        fileHandler.saveAllTransactions(transactions);

        Assertions.assertEquals(fileHandler.loadAllTransactions(), transactions);
    }

    @Test
    public void testLoadAllTransactions() {
        ArrayList<Transaction> transactions = fileHandler.loadAllTransactions();
        Assertions.assertEquals("ice cream", transactions.get(0).description());
    }
}
