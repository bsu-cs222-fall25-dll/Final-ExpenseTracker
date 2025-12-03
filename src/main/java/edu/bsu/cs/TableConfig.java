package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.EnumFilter;
import io.github.palexdev.materialfx.filter.FloatFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class TableConfig {

    private final MFXTableView<Transaction> table;
    private final ObservableList<Transaction> transactionList;

    MFXTableColumn<Transaction> idColumn;
    MFXTableColumn<Transaction> dateColumn;
    MFXTableColumn<Transaction> categoryColumn;
    MFXTableColumn<Transaction> amountColumn;
    MFXTableColumn<Transaction> descriptionColumn;

    public TableConfig(MFXTableView<Transaction> table, ObservableList<Transaction> transactionList) {
        this.table = table;
        this.transactionList = transactionList;
    }

    public void initialize(MFXButton deleteButton) {
        setupTableColumns();
        addTableFilters();
        addDeleteBindListener(deleteButton);

        table.setItems(null);
        table.setItems(transactionList);
        table.features().enableBounceEffect();

    }

    private void setupTableColumns() {
        configureIdColumn();
        configureDateColumn();
        configureCategoryColumn();
        configureAmountColumn();
        configureDescriptionColumn();
    }

    private void addDeleteBindListener(MFXButton deleteButton) {
        table.getSelectionModel().selectionProperty().addListener((observable, oldValue, newValue) -> {
            deleteButton.setDisable(newValue.isEmpty());
        });
    }

    private void configureIdColumn() {
        idColumn = new MFXTableColumn<>("ID", true, Comparator.comparingInt(transactionList::indexOf));
        idColumn.setRowCellFactory(_ -> new MFXTableRowCell<>(cell -> table.getItems().indexOf(cell) + 1));
        table.getTableColumns().add(idColumn);
    }

    private void configureDateColumn() {
        dateColumn = new MFXTableColumn<>("Date", true, Comparator.comparing(Transaction::date));
        dateColumn.setRowCellFactory(_ -> new MFXTableRowCell<>(Transaction::date));
        table.getTableColumns().add(dateColumn);
    }

    private void configureCategoryColumn() {
        categoryColumn = new MFXTableColumn<>("Category", true, Comparator.comparing(Transaction::category));
        categoryColumn.setRowCellFactory(_ -> new MFXTableRowCell<>(Transaction::category));
        table.getTableColumns().add(categoryColumn);
    }

    private void configureAmountColumn() {
        amountColumn = new MFXTableColumn<>("Amount", true, Comparator.comparing(Transaction::amount));
        amountColumn.setRowCellFactory(_ -> new MFXTableRowCell<>(Transaction::amount));
        table.getTableColumns().add(amountColumn);
    }

    private void configureDescriptionColumn() {
        descriptionColumn = new MFXTableColumn<>("Description", true, Comparator.comparing(Transaction::description));
        descriptionColumn.setRowCellFactory(_ -> new MFXTableRowCell<>(Transaction::description));
        table.getTableColumns().add(descriptionColumn);
    }

    private void addTableFilters() {
        table.getFilters().add(new EnumFilter<>("Category", Transaction::category, Category.class));
        table.getFilters().add(new FloatFilter<>("Amount", Transaction::amount));
        table.getFilters().add(new StringFilter<>("Description", Transaction::description));
    }
}
