package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileHandlerTest {
    FileHandler fileHandler = new FileHandler("./src/test/java/edu/bsu/cs/testStore.csv");

    @Test
    public void testSaveAllTransactions() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(42.4F, Category.FOOD, "Spent on ice cream", LocalDate.now()));
        fileHandler.saveAllTransactions(transactions);

        Assertions.assertEquals(fileHandler.loadAllTransactions(), transactions);
    }

    @Test
    public void testLoadAllTransactions() {
        ArrayList<Transaction> transactions = fileHandler.loadAllTransactions();
        Assertions.assertEquals("Spent on ice cream", transactions.getFirst().description());
    }

    @Test
    public void testFileNotFound() {
        FileHandler testFileHandler = new FileHandler("testFileStore.csv");
        Assertions.assertTrue(testFileHandler.loadAllTransactions().isEmpty());
    }

    @Test
    public void testFileHeaderNotFound() {
        FileHandler testFileHandler = new FileHandler("./src/test/java/edu/bsu/cs/testInvalidStore.csv");
        Assertions.assertTrue(testFileHandler.loadAllTransactions().isEmpty());
    }
}
