package edu.bsu.cs;

import java.util.Scanner;

public class Input {
    private final Scanner input = new Scanner(System.in);
    public int getChoice() {
        return input.nextInt();
    }

    public String getDescription() {
        return input.next();
    }

    public int getAmount() {
        return input.nextInt();
    }
}
