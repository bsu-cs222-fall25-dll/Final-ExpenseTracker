package edu.bsu.cs;

import java.time.LocalDate;

public record Transaction(float amount, Category category, String description, LocalDate date) {
}
