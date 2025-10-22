package edu.bsu.cs;

import java.util.ArrayList;

public class Output {
    public void showMenu() {
        System.out.println("""
                ---------------- Menu ----------------
                1. Expense
                2. Income
                3. Remove Transaction
                4. View All Transactions
                5. Exit
                """);
    }

    public void showExpenseMenu() {
        System.out.println("""
                ---------------- Expense Menu ----------------
                1. Add Expense
                2. View Expenses
                """);
    }

    public void showIncomeMenu() {
        System.out.println("""
                ---------------- Income Menu ----------------
                1. Add Income
                2. View Incomes
                """);
    }

    public void showEnterAmount() {
        System.out.print("Enter amount: ");
    }

    public void showEnterDescription() {
        System.out.print("Enter description: ");
    }

    public void showRemoveTransaction() {
        System.out.print("Enter Transaction ID to be removed: ");
    }

    public void showTransactions(ArrayList<Transaction> transactions) {
        System.out.println("---------------- Transaction List ----------------");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            String type = "";
            if (transaction.getType()) type = "Expense";
            else type = "Income";

            System.out.println((i + 1) + ". Amount: $" +
                    transaction.getAmount() +
                    " | Description: " +
                    transaction.getDescription() +
                    " | Type: " +
                    type);
        }
    }

    public void showEnterOption() {
        System.out.print("Enter your option: ");
    }
}
