package edu.bsu.cs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) { this.fileName = fileName; }

    public ArrayList<Transaction> loadAllTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                Transaction transaction = new Transaction(
                        Float.parseFloat(fields[0]),
                        Category.valueOf(fields[1]),
                        fields[2],
                        LocalDate.parse(fields[3]));
                transactions.add(transaction);
            }

            return transactions;
        } catch (IOException e) { return transactions; }
    }

    public void saveAllTransactions(ArrayList<Transaction> transactions) throws IOException {
            FileWriter file = new FileWriter(fileName);
            String header = "amount,category,description,date\n";
            file.write(header);

            for (Transaction transaction : transactions) {
                String line = transaction.amount() + "," + transaction.category() + "," + transaction.description() + "," + transaction.date();
                file.write(line + "\n");
            }

            file.close();
    }
}
