package edu.bsu.cs;

/**
 * @param type True = expense, False = income
 */
public record Transaction(float amount, boolean type, String description) {
}
