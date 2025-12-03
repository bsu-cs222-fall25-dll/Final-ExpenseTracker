package edu.bsu.cs;

import java.time.LocalDate;

public class Validator {

    public boolean checkAddFields(String amountTextField, Category categoryComboBox, LocalDate dateField) {
        if (!checkAmount(amountTextField)) return false;
        else if (!checkCategory(categoryComboBox)) return false;
        else return checkDate(dateField);
    }

    public boolean checkAmount(String amountTextField) {
        try {
            return Float.parseFloat(amountTextField) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkDate(LocalDate dateField) {
        return dateField != null;
    }

    public boolean checkCategory(Category categoryComboBox) { return categoryComboBox != null; }
}
