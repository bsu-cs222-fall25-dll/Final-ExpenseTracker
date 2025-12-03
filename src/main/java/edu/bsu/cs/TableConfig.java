package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.EnumFilter;
import io.github.palexdev.materialfx.filter.FloatFilter;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class TableConfig {

    public void initialize(MFXTableView<Transaction> table, ObservableList<Transaction> transactionList) {
        setupTable(table, transactionList);

        table.autosizeColumnsOnInitialization();
    }

    private void setupTable(MFXTableView<Transaction> table, ObservableList<Transaction> transactionList) {
        MFXTableColumn<Transaction> idColumn = new MFXTableColumn<>("Id", true);
        MFXTableColumn<Transaction> categoryColumn = new MFXTableColumn<>("Category", true, Comparator.comparing(Transaction::category));
        MFXTableColumn<Transaction> amountColumn = new MFXTableColumn<>("Amount", true, Comparator.comparing(Transaction::amount));
        MFXTableColumn<Transaction> descriptionColumn = new MFXTableColumn<>("Description", true, Comparator.comparing(Transaction::description));
        MFXTableColumn<Transaction> dateColumn = new MFXTableColumn<>("Date", true, Comparator.comparing(Transaction::date));

        idColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(cell -> table.getItems().indexOf(cell) + 1));
        categoryColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(Transaction::category));
        amountColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(Transaction::amount));
        descriptionColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(Transaction::description));
        dateColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(Transaction::date));

        table.getTableColumns().addAll(idColumn, categoryColumn, amountColumn, descriptionColumn, dateColumn);
        table.getFilters().addAll(
                new EnumFilter<>("Category", Transaction::category, Category.class),
                new FloatFilter<>("Amount", Transaction::amount)
        );

        table.setItems(null);
        table.setItems(transactionList);
    }
}
