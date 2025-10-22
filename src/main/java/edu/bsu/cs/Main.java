package edu.bsu.cs;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Controller controller = new Controller(store);

        while (true) {
            int option = controller.mainMenu();

            if  (option == 1) {
                controller.expenseMenu();
            } else if (option == 2) {
                controller.incomeMenu();
            } else if (option == 3) {
                controller.removeTransaction();
            } else if (option == 4) {
                controller.getAllTransactions();
            } else if (option == 5) {
                break;
            }
        }

    }
}
