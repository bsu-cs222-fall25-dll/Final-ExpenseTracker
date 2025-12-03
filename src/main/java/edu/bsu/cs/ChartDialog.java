package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

import java.util.EnumMap;
import java.util.Map;

public class ChartDialog {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void showChart(ObservableList<Transaction> transactionList) {
        configureDialogBox();
        PieChart pieChart = configureChart(transactionList);
        alert.getDialogPane().setContent(new VBox(pieChart));
        alert.showAndWait();
    }

    private void configureDialogBox() {
        alert.setTitle("Chart View");
        alert.setHeaderText(null);
    }

    private PieChart configureChart(ObservableList<Transaction> transactionList) {
        ObservableList<PieChart.Data> pieChartData = initializeChartData(transactionList);
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Transactions");

        return pieChart;
    }

    private ObservableList<PieChart.Data> initializeChartData(ObservableList<Transaction> transactionList) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        Map<Category, Float> categoryMap = new EnumMap<>(Category.class);

        for (Transaction transaction: transactionList) {
            float categoryAmount = categoryMap.getOrDefault(transaction.category(), 0.0f);
            categoryMap.put(transaction.category(), categoryAmount + transaction.amount());
        }

        for  (Category category: Category.values()) {
            Float categoryAmount = categoryMap.getOrDefault(category, 0f);
            pieChartData.add(new PieChart.Data(category.name(), categoryAmount));
        }

        return pieChartData;
    }
}
