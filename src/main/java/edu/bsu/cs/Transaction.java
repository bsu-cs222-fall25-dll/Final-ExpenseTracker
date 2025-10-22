package edu.bsu.cs;

public class Transaction {
    private int amount;
    private String description;
    // True = expense, False = income
    private final boolean type;

    public Transaction(int amount, boolean type, String description) {
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getType() {
        return type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
