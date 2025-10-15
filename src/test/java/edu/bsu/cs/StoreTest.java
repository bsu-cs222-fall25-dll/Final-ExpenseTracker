package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void testGetTransaction() {
        Store store = new Store();
        String transaction = store.getTransaction(0);
        Assertions.assertEquals(transaction, "Amount: $0; Description: Spent on icecream;");
    }
}
