package edu.bsu.cs;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Output output = new Output();
        Controller controller = new Controller(store);

        boolean continueLoop = true;
        while (continueLoop) {
            int option = controller.mainMenu();

            switch (option) {
                case 1:
                    controller.expenseMenu();
                    break;
                case 2:
                    controller.incomeMenu();
                    break;
                case 3:
                    controller.removeTransaction();
                    break;
                case 4:
                    controller.getAllTransactions();
                    break;
                case 5:
                    continueLoop = false;
                    break;
                default:
                    output.showInvalidOptionError();
                    break;
            }
        }

    }
}
