package edu.bsu.cs;

public class Validator {

    public boolean checkAddFields(String amountTextField, Category categoryComboBox) {
        if (!checkAmount(amountTextField)) return false;
        return checkCategory(categoryComboBox);
    }

    public boolean checkAmount(String amountTextField) {
        try {
            return Float.parseFloat(amountTextField) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkId(String idTextField) {
        try {
            Integer.parseInt(idTextField);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkCategory(Category categoryComboBox) { return categoryComboBox != null; }
}
