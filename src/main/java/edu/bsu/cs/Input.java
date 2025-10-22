package edu.bsu.cs;

import java.util.Scanner;

public class Input {
    private final Scanner input = new Scanner(System.in);
    public int getOption() {
        return Integer.parseInt(input.nextLine());
    }

    public String getDescription() {
        return input.nextLine();
    }

    public float getAmount() {
        return Float.parseFloat(input.nextLine());
    }
}
