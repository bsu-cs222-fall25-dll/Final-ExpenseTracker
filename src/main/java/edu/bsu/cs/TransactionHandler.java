package edu.bsu.cs;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

// This is not testable because it is integrated with JavaFX ObservableList
public class TransactionHandler {

    private final String FILE_NAME = "transactions.csv";
    private final Store store = new Store(FILE_NAME);
    private final Validator validator = new Validator();
    private final ObservableList<Transaction> transactionList;

    public TransactionHandler(ObservableList<Transaction> transactionList) { this.transactionList = transactionList; }

    public ObservableList<Transaction> initialize() {
        ArrayList<Transaction> transactions = store.getAllTransactions();
        transactionList.addAll(transactions);
        return transactionList;
    }

    public boolean addTransaction(Category categoryComboBox, String amountTextField, String descriptionTextField, LocalDate dateField) throws IOException {
        if (!validator.checkAddFields(amountTextField, categoryComboBox, dateField)) return false;
        String description = descriptionTextField;
        if (descriptionTextField.isEmpty()) description = " ";

        Transaction transaction = new Transaction(Float.parseFloat(amountTextField), categoryComboBox, description, dateField);
        store.addTransaction(transaction);
        transactionList.add(transaction);
        return true;
    }

    public void removeTransaction(int index) throws IOException {
        transactionList.remove(index);
        store.removeTransaction(index);
    }

    public float getTotalExpense() {
        float income = 0;
        float expense = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.category() != Category.INCOME) expense += transaction.amount();
            else income += transaction.amount();
        }
        return income - expense;
    }
}
