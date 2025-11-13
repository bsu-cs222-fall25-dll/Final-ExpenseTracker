package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class TableStore {

    private final String FILE_NAME = "transactions.csv";
    private final Store store = new Store(FILE_NAME);
    private final Validator validator = new Validator();
    private final ObservableList<Transaction> transactionList = FXCollections.observableArrayList();

    public ObservableList<Transaction> initialize() {
        ArrayList<Transaction> transactions = store.getAllTransactions();
        transactionList.addAll(transactions);
        return transactionList;
    }

    public boolean addTransaction(String typeComboBox, String amountTextField, String descriptionTextField) {
        if (!validator.checkAddFields(amountTextField, descriptionTextField,typeComboBox)) return false;
        boolean transactionType = typeComboBox.equals("Expense");
        Transaction transaction = new Transaction(Float.parseFloat(amountTextField), transactionType, descriptionTextField);
        store.addTransaction(transaction);
        transactionList.add(transaction);
        return true;
    }

    public boolean removeTransaction(String idTextField) {
        if (!validator.checkId(idTextField)) return false;
        int index = Integer.parseInt(idTextField);
        transactionList.remove(index);
        store.removeTransaction(index);
        return true;
    }
}
