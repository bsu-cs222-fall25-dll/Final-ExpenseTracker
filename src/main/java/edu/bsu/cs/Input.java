package edu.bsu.cs;

import java.util.Scanner;

public class Input {
    private final Output output = new Output();
    private final Scanner input = new Scanner(System.in);

    public int getOption() {
        try {
            return Integer.parseInt(input.nextLine());
        }  catch (NumberFormatException e) {
            output.showInvalidOptionError();
            return getOption();
        }
    }

    public String getDescription() { return input.nextLine(); }

    public float getAmount() {
        try {
            return Float.parseFloat(input.nextLine());
        }  catch (NumberFormatException e) {
            output.showInvalidOptionError();
            return getAmount();
        }
    }
}
