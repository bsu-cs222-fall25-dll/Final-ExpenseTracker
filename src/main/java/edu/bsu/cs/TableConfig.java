package edu.bsu.cs;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

public class TableConfig {

    public void initialize(
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
            Category category = cellData.getValue().type();
            return new SimpleStringProperty(category.name());
        });
    }

    private void configureAmountColumn(TableColumn<Transaction, Float> amountColumn) {
        amountColumn.setCellValueFactory(cellData -> {
            float amount = cellData.getValue().amount();
            return new SimpleFloatProperty(amount).asObject();
        });
    }

    private void configureDescriptionColumn(TableColumn<Transaction, String> descriptionColumn) {
        descriptionColumn.setCellValueFactory(cellData -> {
            String description = cellData.getValue().description();
            return new SimpleStringProperty(description);
        });
    }
}
