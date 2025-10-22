package edu.bsu.cs;

public class Transaction {
    private float amount;
    private String description;
    private final boolean type; // True = expense, False = income

    public Transaction(float amount, boolean type, String description) {
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public boolean getType() {
        return type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
