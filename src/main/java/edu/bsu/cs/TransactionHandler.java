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
    private final ObservableList<Transaction> transactionList;

    TransactionHandler(ObservableList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public ObservableList<Transaction> initialize() {
        ArrayList<Transaction> transactions = store.getAllTransactions();
        transactionList.addAll(transactions);
        return transactionList;
    }

    public boolean addTransaction(Category categoryComboBox, String amountTextField, String descriptionTextField, String dateTextField) throws IOException {
        if (!validator.checkAddFields(amountTextField, categoryComboBox)) return false;
        String description = descriptionTextField;
        String date = dateTextField;
        if (descriptionTextField.isEmpty()) description = " ";
        if (dateTextField.isEmpty()) date = " ";

        Transaction transaction = new Transaction(Float.parseFloat(amountTextField), categoryComboBox, description, date);
        store.addTransaction(transaction);
        transactionList.add(transaction);
        return true;
    }

    public boolean removeTransaction(String idTextField) throws IOException {
        if (!validator.checkId(idTextField)) return false;
        int index = Integer.parseInt(idTextField) - 1;
        transactionList.remove(index);
        store.removeTransaction(index);
        return true;
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
