package edu.bsu.cs;

public class Validator {

    public boolean checkAddFields(String amountTextField, String typeComboBox) {
        if (!checkAmount(amountTextField)) return false;
        return checkType(typeComboBox);
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

    public boolean checkType(String typeComboBox) { return !typeComboBox.isEmpty(); }
}
