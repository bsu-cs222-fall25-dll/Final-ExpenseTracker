package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
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

    public boolean addTransaction(MFXComboBox<String> typeComboBox, MFXTextField amountTextField, MFXTextField descriptionTextField) {
        if (!validator.checkAddFields(amountTextField.getText(), descriptionTextField.getText(),typeComboBox.getText())) return false;
        boolean transactionType = typeComboBox.getValue().equals("Expense");
        Transaction transaction = new Transaction(Float.parseFloat(amountTextField.getText()), transactionType, descriptionTextField.getText());
        store.addTransaction(transaction);
        transactionList.add(transaction);
        return true;
    }

    public boolean removeTransaction(MFXTextField idTextField) {
        if (!validator.checkId(idTextField.getText())) return false;
        int index = Integer.parseInt(idTextField.getText());
        transactionList.remove(index);
        store.removeTransaction(index);
        return true;
    }
}
