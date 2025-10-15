package edu.bsu.cs;

import java.util.ArrayList;

public class Store {
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(int amount, String description) {
        Transaction transaction = new Transaction(amount, description);
        transactions.add(transaction);
    }

    public Transaction getTransaction(int index) { return transactions.get(index); }
}
