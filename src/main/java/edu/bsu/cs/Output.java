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

    public void showMenu() {
        System.out.print("\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(ANSI_GREEN +"===============================================================");
        System.out.println("|                                                             |");
        System.out.println("|   " + ANSI_GREEN + "_____                                      "  + "               |");
        System.out.println("|  "  + ANSI_GREEN + "| ____|_  ___ __   ___ _ __  ___  ___  ___ "  + "                |");
        System.out.println("|  "  + ANSI_GREEN + "|  _| \\ \\/ / '_ \\ / _ \\ '_ \\/ __|/ _ \\/ __|"  + "                |");
        System.out.println("|  "  + ANSI_GREEN + "| |___ >  <| |_) |  __/ | | \\__ \\  __/\\__ \\"  + "                |");
        System.out.println("|  "  + ANSI_GREEN + "|_____/_/\\_\\ .__/ \\___|_| |_|___/\\___||___/"  + "                |");
        System.out.println("|             " + ANSI_GREEN + "|_|"  + "                                             |");
        System.out.println("|                                                             |");
        System.out.println("|   " + ANSI_GREEN + "_______             _                 "  + "                    |");
        System.out.println("|  "  + ANSI_GREEN + "|__   __|           | |                " + "                    |");
        System.out.println("|     " + ANSI_GREEN + "| |_ __ __ _  ___| | _____ _ __     " + "                    |");
        System.out.println("|     " + ANSI_GREEN + "| | '__/ _` |/ __| |/ / _ \\ '__|    " + "                    |");
        System.out.println("|     " + ANSI_GREEN + "| | | | (_| | (__|   <  __/ |       " + "                    |");
        System.out.println("|     " + ANSI_GREEN + "|_|_|  \\__,_|\\___|_|\\_\\___|_|       " + "                    |");
        System.out.println("|                                                             |");
        System.out.println("===============================================================" + ANSI_RESET );
        System.out.println();

        System.out.println(ANSI_GREEN + "---------------------------------------------------------------");
        System.out.println("|                          MENU                               |");
        System.out.println("---------------------------------------------------------------" + ANSI_RESET);
        System.out.println("|                                                             |");
        System.out.println("|   " + ANSI_CYAN + "1. Expense" + ANSI_RESET + "                                                |");
        System.out.println("|   " + ANSI_CYAN + "2. Income" + ANSI_RESET + "                                                 |");
        System.out.println("|   " + ANSI_CYAN + "3. Remove Transaction" + ANSI_RESET + "                                     |");
        System.out.println("|   " + ANSI_CYAN + "4. View All Transactions" + ANSI_RESET + "                                  |");
        System.out.println("|   " + ANSI_RED + "5. Exit" + ANSI_RESET + "                                                   |");
        System.out.println(ANSI_GREEN + "|                                                             |");
        System.out.println("---------------------------------------------------------------" + ANSI_RESET);





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

    public void showEnterAmount() { System.out.print(ANSI_CYAN +"Enter amount: "+ ANSI_RESET); }

    public void showEnterDescription() { System.out.print(ANSI_CYAN + "Enter description: " + ANSI_RESET); }

    public void showRemoveTransaction() { System.out.print(ANSI_CYAN + "Enter Transaction ID to be removed: " + ANSI_RESET); }

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

    public void showEnterOption() { System.out.print("Enter your option: "); }
}
