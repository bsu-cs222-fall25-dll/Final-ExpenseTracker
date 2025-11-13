package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private final TableStore tableStore = new TableStore();
    private final Error error = new Error();

    @FXML private MFXComboBox<String> typeComboBox;
    @FXML private MFXTextField amountTextField;
    @FXML private MFXTextField descriptionTextField;
    @FXML private MFXTextField idTextField;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, Integer> idColumn;
    @FXML private TableColumn<Transaction, String> typeColumn;
    @FXML private TableColumn<Transaction, Float> amountColumn;
    @FXML private TableColumn<Transaction, String> descriptionColumn;

    @FXML
    private void initialize() {
        loadComboBox();
        loadTable();
    }

    @SuppressWarnings("unused")
    @FXML
    private void addTransaction(ActionEvent actionEvent) {
        boolean transactionStatus = tableStore.addTransaction(typeComboBox, amountTextField, descriptionTextField);
        if (!transactionStatus) error.showInvalidTypeError();
        else clearFields();
    }

    @SuppressWarnings("unused")
    @FXML
    private void removeTransaction(ActionEvent actionEvent) {
        boolean transactionStatus = tableStore.removeTransaction(idTextField);
        if (!transactionStatus) error.showInvalidTypeError();
        else clearFields();
    }

    private void loadComboBox() {
        typeComboBox.getItems().removeAll(typeComboBox.getItems());
        typeComboBox.getItems().addAll("Expense", "Income");
    }

    private void loadTable() {
        TableConfig table = new TableConfig();
        table.configureTable(idColumn, typeColumn, amountColumn, descriptionColumn);
        transactionTable.setItems(tableStore.initialize());
    }

    private void clearFields() {
        amountTextField.clear();
        descriptionTextField.clear();
        idTextField.clear();
        typeComboBox.clear();
    }
}
