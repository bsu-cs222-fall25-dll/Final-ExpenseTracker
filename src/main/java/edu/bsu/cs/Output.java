package edu.bsu.cs;

public class Output {
    public void showMenu() {
        System.out.println("Total : ");
        System.out.println("Expense : ");
        System.out.println("Income : ");
        System.out.println("---------------- Menu ----------------");
        System.out.println("1. Edit Expense");
        System.out.println("2. Edit Income");
        System.out.println("3. View All Transactions");
    }
     public void showExpenseMenu(){
        System.out.println("---------------- Expense ----------------");
        showSecondaryOptions();
     }
     public void showIncomeMenu(){
        System.out.println("-------------- Income ---------------");
        showSecondaryOptions();
     }

     public void showSecondaryOptions() {
         System.out.println("1. Add Transaction");
         System.out.println("2. Remove Transaction");
         System.out.println("3. View Transactions");
     }

     public void showTransaction(){
        System.out.println("-------------- Transactions ----------------");
     }

      public void userAmountRequest(){
        System.out.println("Enter amount : ");
      }

      public void userDescriptionRequest(){
        System.out.println("Enter description : ");
      }
}
