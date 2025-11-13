package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void testCheckAmount() {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.checkAmount("65.56F"));
    }

    @Test
    public void testCheckNotAmount() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.checkAmount("test"));
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
