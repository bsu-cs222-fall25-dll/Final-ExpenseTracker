package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testCheckAddFields() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkAddFields("300", "test", "Expense"));
    }

    @Test
    public void testCheckInvalidAmountAddFields() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAddFields("300", "", "Expense"));
    }

    @Test
    public void testCheckInvalidTypeAddFields() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAddFields("300", "test", ""));
    }

    @Test
    public void testCheckInvalidDescriptionAddFields() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAddFields("wrong", "test", "Expense"));
    }

    @Test
    public void testCheckAmount() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkAmount("65.56"));
    }

    @Test
    public void testCheckNotAmount() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAmount("test"));
    }

    @Test
    public void testCheckNegativeAmount() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAmount("-200"));
    }

    @Test
    public void testCheckId() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkId("3"));
    }

    @Test
    public void testCheckNotId() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkId("test"));
    }

    @Test
    public void testCheckDescription() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkDescription("ice cream"));
    }

    @Test
    public void testCheckNotDescription() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkId(""));
    }

    @Test
    public void testCheckType() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkType("Expense"));
    }

    @Test
    public void testCheckNotType() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkType(""));
    }
}
