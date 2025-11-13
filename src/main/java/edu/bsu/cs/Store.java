package edu.bsu.cs;

import java.util.ArrayList;

public class Store {

    private final FileHandler fileHandler;

    public Store(String fileName) { this.fileHandler = new FileHandler(fileName); }

    public void addTransaction(Transaction transaction) {
        ArrayList<Transaction> transactions = fileHandler.loadAllTransactions();
        transactions.add(transaction);
        fileHandler.saveAllTransactions(transactions);
    }

    public void removeTransaction(int index) {
        ArrayList<Transaction> transactions = fileHandler.loadAllTransactions();
        transactions.remove(index);
        fileHandler.saveAllTransactions(transactions);
    }

    public ArrayList<Transaction> getAllTransactions() { return fileHandler.loadAllTransactions(); }
}
