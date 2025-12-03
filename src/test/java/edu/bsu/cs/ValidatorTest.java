package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ValidatorTest {

    @Test
    public void testCheckAddFields() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkAddFields("300", Category.GAS, LocalDate.now()));
    }

    @Test
    public void testCheckInvalidAmountAddFields() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAddFields("test", Category.GAS, LocalDate.now()));
    }

    @Test
    public void testCheckInvalidCategoryAddFields() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAddFields("300", null, LocalDate.now()));
    }

    @Test
    public void testCheckInvalidDateAddFields() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAddFields("300", Category.GAS, null));
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
    public void testCheckDate() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkDate(LocalDate.now()));
    }

    @Test
    public void testCheckNotDate() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkDate(null));
    }

    @Test
    public void testCheckCategory() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkCategory(Category.FOOD));
    }

    @Test
    public void testCheckNotCategory() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkCategory(null));
    }
}
