package edu.bsu.cs;

import java.util.ArrayList;

public class Output {
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_RED = "\u001b[31;4m";
    public static final String ANSI_GREEN = "\u001b[92;1m";
    public static final String ANSI_BLUE = "\u001b[34;1m";
    public static final String ANSI_YELLOW = "\u001b[93;1m";
    public static final String ANSI_MAGENTA = "\u001b[35;1m";
    public static final String ANSI_CYAN = "\u001B[4;96m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void showMenu() {
        System.out.println("\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(ANSI_BLUE + """
                ===============================================================
                ||                         MENU                              ||
                ===============================================================""");
        System.out.println("||  " + ANSI_GREEN + "1. Expense Menu" + ANSI_RESET + "                                          " + ANSI_BLUE + "||");
        System.out.println("||  " + ANSI_GREEN + "2. Income Menu" + ANSI_RESET + "                                           " + ANSI_BLUE + "||");
        System.out.println("||  " + ANSI_GREEN + "3. Remove Transaction" + ANSI_RESET + "                                    " + ANSI_BLUE + "||");
        System.out.println("||  " + ANSI_GREEN + "4. View All Transactions" + ANSI_RESET + "                                 " + ANSI_BLUE + "||");
        System.out.println("||  " + ANSI_GREEN + "5. Exit" + ANSI_RESET + "                                                  " + ANSI_BLUE + "||");
        System.out.println("===============================================================" + ANSI_RESET);
    }

    public void showExpenseMenu() {
        System.out.println(ANSI_BLUE + """
                ===============================================================
                ||                     EXPENSE MENU                          ||
                ===============================================================""");
        System.out.println("||  " + ANSI_GREEN + "1. Add Expense" + ANSI_RESET + "                                           " + ANSI_BLUE + "||");
        System.out.println("||  " + ANSI_GREEN + "2. View Expenses" + ANSI_RESET + "                                         " + ANSI_BLUE + "||");
        System.out.println("===============================================================" + ANSI_RESET);
    }

    public void showIncomeMenu() {
        System.out.println(ANSI_BLUE + """
                ===============================================================
                ||                      INCOME MENU                          ||
                ===============================================================""");
        System.out.println("||  " + ANSI_GREEN + "1. Add Income" + ANSI_RESET + "                                           " + ANSI_BLUE + "||");
        System.out.println("||  " + ANSI_GREEN + "2. View Income" + ANSI_RESET + "                                         " + ANSI_BLUE + "||");
        System.out.println("===============================================================" + ANSI_RESET);
    }

    public void showTransactions(ArrayList<Transaction> transactions) {
        System.out.println(ANSI_YELLOW + """
                ===============================================================
                ||                   TRANSACTION LIST                        ||
                ===============================================================""");

        float expenses = 0;
        float incomes = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            String type = "";
            if (transaction.type()) {
                type = "Expense";
                expenses += transaction.amount();
            } else {
                type = "Income";
                incomes += transaction.amount();
            }

            System.out.println(ANSI_WHITE + (i + 1) + ". Amount: $" +
                    transaction.amount() +
                    " | Description: " +
                    transaction.description() +
                    " | Type: " +
                    type + ANSI_RESET);
        }

        System.out.println(ANSI_YELLOW + "===============================================================" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "Expenses: $" +
                expenses +
                " | Incomes: $" +
                incomes +
                " | Total: $" +
                (incomes - expenses) + ANSI_RESET);
    }

    public void showEnterAmount() { System.out.print(ANSI_MAGENTA + ">>> Enter amount: " + ANSI_RESET); }

    public void showEnterDescription() { System.out.print(ANSI_MAGENTA +">>> Enter description: " + ANSI_RESET); }

    public void showRemoveTransaction() { System.out.print(ANSI_MAGENTA +">>> Enter Transaction ID to be removed: " + ANSI_RESET); }

    public void showEnterOption() { System.out.print(ANSI_MAGENTA +">>> Enter option: " + ANSI_RESET); }

    public void showInvalidOptionError() {
        System.out.println(ANSI_RED +"!!!!!!!! The value you entered is an invalid type for this option. TRY AGAIN !!!!!!!!" + ANSI_RESET);
        System.out.print(ANSI_MAGENTA +">>> " + ANSI_RESET);
    }
}
