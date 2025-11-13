package edu.bsu.cs;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

public class TableConfig {

    public void configureTable(
            TableColumn<Transaction, Integer> idColumn,
            TableColumn<Transaction, String> typeColumn,
            TableColumn<Transaction, Float> amountColumn,
            TableColumn<Transaction, String> descriptionColumn
    ) {
        configureIdColumn(idColumn);
        configureTypeColumn(typeColumn);
        configureAmountColumn(amountColumn);
        configureDescriptionColumn(descriptionColumn);
    }

    private void configureIdColumn(TableColumn<Transaction, Integer> idColumn) {
        idColumn.setCellFactory(_ -> new TableCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) setText(null);
                else setText(String.valueOf(getIndex()));
            }
        });
    }

    private void configureTypeColumn(TableColumn<Transaction, String> typeColumn) {
        typeColumn.setCellValueFactory(cellData -> {
            boolean isExpense = cellData.getValue().type();
            String typeStr = isExpense ? "Expense" : "Income";
            return new SimpleStringProperty(typeStr);
        });
    }

    private void configureAmountColumn(TableColumn<Transaction, Float> amountColumn) {
        amountColumn.setCellValueFactory(cellData -> {
            float amt = cellData.getValue().amount();
            return new SimpleFloatProperty(amt).asObject();
        });
    }

    private void configureDescriptionColumn(TableColumn<Transaction, String> descriptionColumn) {
        descriptionColumn.setCellValueFactory(cellData -> {
            String desc = cellData.getValue().description();
            return new SimpleStringProperty(desc);
        });
    }
}
