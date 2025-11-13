package edu.bsu.cs;

public class Validator {

    public boolean checkAddFields(String amountTextField, String descriptionTextField, String typeComboBox) {
        if (!checkAmount(amountTextField)) return false;
        if (!checkDescription(descriptionTextField)) return false;
        return checkType(typeComboBox);
    }

    public boolean checkAmount(String amountTextField) {
        try {
            Float.parseFloat(amountTextField);
            return true;
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

    public boolean checkDescription(String descriptionTextField) { return !descriptionTextField.isEmpty(); }
}
