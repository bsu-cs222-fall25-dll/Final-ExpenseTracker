package edu.bsu.cs;

import java.util.ArrayList;

public class Store {
    private final Reader reader;

    public Store(String fileName) { this.reader = new Reader(fileName); }

    public void addTransaction(float amount, boolean type, String description) {
        ArrayList<Transaction> transactions = reader.loadAllTransactions();
        Transaction transaction = new Transaction(amount, type, description);
        transactions.add(transaction);
        reader.saveAllTransactions(transactions);
    }

    public void removeTransaction(int index) {
        ArrayList<Transaction> transactions = reader.loadAllTransactions();
        transactions.remove(index);
        reader.saveAllTransactions(transactions);
    }

    public Transaction getTransaction(int index) {
        ArrayList<Transaction> transactions = reader.loadAllTransactions();
        return transactions.get(index);
    }

    public ArrayList<Transaction> getAllTransactions() { return reader.loadAllTransactions(); }
}
