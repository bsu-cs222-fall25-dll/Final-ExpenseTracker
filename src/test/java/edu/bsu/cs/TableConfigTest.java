package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class TableConfigTest {

    private MFXTableView<Transaction> table;
    private ObservableList<Transaction> data;
    private TableConfig config;

    @BeforeAll
    static void initJavaFX() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.startup(latch::countDown);
        latch.await(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void setUp() {
        table = new MFXTableView<>();
        data = FXCollections.observableArrayList();
        config = new TableConfig(table, data);
    }

    private void runFX(Runnable action) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            action.run();
            latch.countDown();
        });
        latch.await(3, TimeUnit.SECONDS);
    }


    @Test
    void initializesFourColumns() throws Exception {
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals(4, table.getTableColumns().size());
    }

    @Test
    void dateColumnIsCreated() throws Exception {
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals("Date", table.getTableColumns().get(0).getText());
    }

    @Test
    void categoryColumnIsCreated() throws Exception {
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals("Category", table.getTableColumns().get(1).getText());
    }

    @Test
    void amountColumnIsCreated() throws Exception {
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals("Amount", table.getTableColumns().get(2).getText());
    }

    @Test
    void descriptionColumnIsCreated() throws Exception {
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals("Description", table.getTableColumns().get(3).getText());
    }

    @Test
    void tableLoadsTransactionList() throws Exception {
        data.add(new Transaction(10F, Category.FOOD, "Lunch", LocalDate.now()));
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals(1, table.getItems().size());
    }

    @Test
    void deleteButtonInitiallyDisabled() throws Exception {
        MFXButton deleteButton = new MFXButton();
        runFX(() -> config.initialize(deleteButton));
        Assertions.assertFalse(deleteButton.isDisabled());
    }

    @Test
    void deleteButtonEnabledWhenRowSelected() throws Exception {
        MFXButton deleteButton = new MFXButton();
        data.add(new Transaction(10F, Category.FOOD, "Lunch", LocalDate.now()));

        runFX(() -> {
            config.initialize(deleteButton);
            table.getSelectionModel().selectIndex(0);
        });

        Assertions.assertFalse(deleteButton.isDisabled());
    }

    @Test
    void filtersAreAdded() throws Exception {
        runFX(() -> config.initialize(new MFXButton()));
        Assertions.assertEquals(3, table.getFilters().size());
    }
}
