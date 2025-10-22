package edu.bsu.cs;

import java.util.ArrayList;

public class Controller {
    private final Output output = new Output();
    private final Input input = new Input();
    private final Store store;

    public Controller(Store store) {
        this.store = store;
    }

    public int mainMenu() {
        output.showMenu();
        output.showEnterOption();
        return input.getOption();
    }

    public void expenseMenu() {
        output.showExpenseMenu();
        output.showEnterOption();
        int option = input.getOption();

        if (option == 1) {
            addTransaction(true);
        }   else if (option == 2) {
            getSpecificTransactions(true);
        }
    }

    public void incomeMenu() {
        output.showIncomeMenu();
        output.showEnterOption();
        int option = input.getOption();

        if (option == 1) {
            addTransaction(false);
        }   else if (option == 2) {
            getSpecificTransactions(false);
        }
    }

    public void addTransaction(boolean type) {
        output.showEnterAmount();
        float amount = input.getAmount();
        output.showEnterDescription();
        String description = input.getDescription();
        store.addTransaction(amount, type, description);
    }

    public void removeTransaction() {
        output.showRemoveTransaction();
        int option = input.getOption();
        store.removeTransaction(option - 1);
    }

    public void getAllTransactions() {
        output.showTransactions(store.getAllTransactions());
    }

    public void getSpecificTransactions(boolean type) {
        ArrayList<Transaction> typeTransaction = new ArrayList<>();
        for (Transaction transaction : store.getAllTransactions()) {
            if (transaction.getType() == type) {
                typeTransaction.add(transaction);
            }
        }
        output.showTransactions(typeTransaction);
    }
}
