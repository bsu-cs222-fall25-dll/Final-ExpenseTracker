package edu.bsu.cs;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

public class TableConfig {

    public void initialize(
            TableColumn<Transaction, Integer> idColumn,
            TableColumn<Transaction, Category> categoryColumn,
            TableColumn<Transaction, Float> amountColumn,
            TableColumn<Transaction, String> descriptionColumn
    ) {
        configureIdColumn(idColumn);
        configureCategoryColumn(categoryColumn);
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

    private void configureCategoryColumn(TableColumn<Transaction, Category> categoryColumn) {
        categoryColumn.setCellValueFactory(cellData -> {
            Category category = cellData.getValue().category();
            return new SimpleObjectProperty<Category>(category);
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
