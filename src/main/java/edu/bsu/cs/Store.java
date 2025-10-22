package edu.bsu.cs;

import java.util.ArrayList;

public class Store {
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(int amount, boolean type, String description) {
        Transaction transaction = new Transaction(amount, type, description);
        transactions.add(transaction);
    }

    public void removeTransaction(int index) { transactions.remove(index); }

    public Transaction getTransaction(int index) { return transactions.get(index); }

    public ArrayList<Transaction> getAllTransactions() { return transactions; }
}
