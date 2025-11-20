package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

// This is not testable because it is integrated with JavaFX ObservableList
public class TransactionHandler {

    private final String FILE_NAME = "transactions.csv";
    private final Store store = new Store(FILE_NAME);
    private final Validator validator = new Validator();
    private final ObservableList<Transaction> transactionList = FXCollections.observableArrayList();

    public ObservableList<Transaction> initialize() {
        ArrayList<Transaction> transactions = store.getAllTransactions();
        transactionList.addAll(transactions);
        return transactionList;
    }

    public boolean addTransaction(String typeComboBox, String amountTextField, String descriptionTextField) throws IOException {
        if (!validator.checkAddFields(amountTextField, typeComboBox)) return false;
        Transaction transaction = new Transaction(Float.parseFloat(amountTextField), Category.valueOf(typeComboBox), descriptionTextField);
        store.addTransaction(transaction);
        transactionList.add(transaction);
        return true;
    }

    public boolean removeTransaction(String idTextField) throws IOException {
        if (!validator.checkId(idTextField)) return false;
        int index = Integer.parseInt(idTextField);
        transactionList.remove(index);
        store.removeTransaction(index);
        return true;
    }

    public float getTotalExpense() {
        float income = 0;
        float expense = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.type() != Category.INCOME) expense += transaction.amount();
            else income += transaction.amount();
        }
        return income - expense;
    }
}
