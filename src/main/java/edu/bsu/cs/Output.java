package edu.bsu.cs;

import java.util.ArrayList;

public class Output {
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_RED = "\u001b[31;1m";
    public static final String ANSI_GREEN = "\u001b[32;1m";
    public static final String ANSI_BLUE = "\u001b[34;1m";
    public static final String ANSI_YELLOW = "\u001b[33;1m";
    public static final String ANSI_MAGENTA = "\u001b[35;1m";
    public static final String ANSI_CYAN = "\u001b[36;1m";

    public void showMenu() {
        System.out.print("\n");
        System.out.println(ANSI_GREEN + """ 
                 _____                                  _____               _            \s
                | ____|_  ___ __   ___ _ __  ___  ___  |_   _| __ __ _  ___| | _____ _ __\s
                |  _| \\ \\/ / '_ \\ / _ \\ '_ \\/ __|/ _ \\   | || '__/ _` |/ __| |/ / _ \\ '__|
                | |___ >  <| |_) |  __/ | | \\__ \\  __/   | || | | (_| | (__|   <  __/ |  \s
                |_____/_/\\_\\ .__/ \\___|_| |_|___/\\___|   |_||_|  \\__,_|\\___|_|\\_\\___|_|  \s
                           |_|                                                           \s
                """ + ANSI_RESET);

        System.out.println(ANSI_GREEN + " ---------------- Menu ----------------" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "1. Expense" + ANSI_RESET);
        System.out.println(ANSI_MAGENTA + "2. Income" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3. Remove Transaction" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "4. View All Transactions" + ANSI_RESET);
        System.out.println(ANSI_RED + "5. Exit" + ANSI_RESET);


    }

    public void showExpenseMenu() {
        System.out.println(ANSI_GREEN + "---------------- Expense Menu ---------------- \n" + ANSI_RESET +
                ANSI_CYAN +"1. Add Expense " + ANSI_RESET +
                "\n2. View Expenses");
    }

    public void showIncomeMenu() {
        System.out.println(ANSI_GREEN + "---------------- Income Menu ---------------- \n" + ANSI_RESET +
                ANSI_CYAN + "1. Add Income\n" + ANSI_RESET +
                "2. View Income\n");
    }

    public void showEnterAmount() {
        System.out.print(ANSI_CYAN +"Enter amount: "+ ANSI_RESET);
    }

    public void showEnterDescription() {
        System.out.print(ANSI_CYAN + "Enter description: " + ANSI_RESET);
    }

    public void showRemoveTransaction() {
        System.out.print(ANSI_CYAN + "Enter Transaction ID to be removed: " + ANSI_RESET);
    }

    public void showTransactions(ArrayList<Transaction> transactions) {
        System.out.println(ANSI_GREEN + "---------------- Transaction List ----------------" + ANSI_RESET);
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            String type = "";
            if (transaction.type()) type = "Expense";
            else type = "Income";

            System.out.println((i + 1) + ". Amount: $" +
                    transaction.amount() +
                    " | Description: " +
                    transaction.description() +
                    " | Type: " +
                    type);
        }
    }

    public void showEnterOption() {
        System.out.print("Enter your option: ");
    }
}
