package edu.bsu.cs;

public class Main {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        Expense expense = new Expense();
        Income income = new Income();

        output.showMenu();

        int choice = input.getChoice();
        int amount;
        String description;
        if  (choice == 1) {
            amount = input.getAmount();
            description = input.getDescription();
            expense.addTransaction(amount, description);
        } else  if  (choice == 2) {
        }
    }
}
