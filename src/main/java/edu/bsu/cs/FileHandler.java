package edu.bsu.cs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) { this.fileName = fileName; }

    public ArrayList<Transaction> loadAllTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                Transaction transaction = new Transaction(
                        Float.parseFloat(fields[0]),
                        Boolean.parseBoolean(fields[1]),
                        fields[2]);
                transactions.add(transaction);
            }

            return transactions;
        } catch (IOException e) { return transactions; }
    }

    public void saveAllTransactions(ArrayList<Transaction> transactions) {
        try {
            FileWriter file = new FileWriter(fileName);
            String header = "amount,type,description\n";
            file.write(header);

            for (Transaction transaction : transactions) {
                String line = transaction.amount() + "," + transaction.type() + "," + transaction.description();
                file.write(line + "\n");
            }

            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
