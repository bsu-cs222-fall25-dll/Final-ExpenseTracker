package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {

    private final ErrorDialog errorDialog = new ErrorDialog();
    private final ObservableList<Transaction> transactionList = FXCollections.observableArrayList();
    private final TransactionHandler transactionHandler = new TransactionHandler(transactionList);

    @FXML private MFXComboBox<Category> categoryComboBox;
    @FXML private MFXTextField amountTextField;
    @FXML private MFXTextField descriptionTextField;
    @FXML private MFXTextField idTextField;
    @FXML private MFXTextField dateTextField;
    @FXML private MFXTableView<Transaction> transactionTable;
    @FXML private Label totalExpense;

    @FXML private void initialize() {
        loadComboBox();
        loadTable();
        setTotalExpense();
    }

    @SuppressWarnings("unused")
    @FXML private void addTransaction(ActionEvent actionEvent) {
        try {
            boolean transactionStatus = transactionHandler.addTransaction(categoryComboBox.getValue(), amountTextField.getText(), descriptionTextField.getText(), dateTextField.getText());
            if (!transactionStatus) errorDialog.showInvalidTypeError();
            else {
                setTotalExpense();
                clearFields();
            }
        } catch (IOException exception) { errorDialog.showWriteFailedError(); }
    }

    @SuppressWarnings("unused")
    @FXML private void removeTransaction(ActionEvent actionEvent) {
        try {
            boolean transactionStatus = transactionHandler.removeTransaction(idTextField.getText());
            if (!transactionStatus) errorDialog.showInvalidTypeError();
            else {
                setTotalExpense();
                clearFields();
            }
        } catch (IOException exception) { errorDialog.showWriteFailedError(); }
    }

    private void loadComboBox() {
        categoryComboBox.getItems().removeAll(categoryComboBox.getItems());
        categoryComboBox.getItems().addAll(Category.values());
    }

    private void loadTable() {
        transactionTable.setItems(transactionHandler.initialize());
        TableConfig tableConfig = new TableConfig();
        tableConfig.initialize(transactionTable, transactionList);
    }

    private void setTotalExpense() { totalExpense.setText(String.format("$%.2f", transactionHandler.getTotalExpense())); }

    private void clearFields() {
        amountTextField.clear();
        descriptionTextField.clear();
        idTextField.clear();
        categoryComboBox.clear();
        dateTextField.clear();
    }
}
