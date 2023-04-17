package bank_account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BankAccount {

    private Integer Balance = 0;
    private ArrayList<String> statement = new ArrayList<String>(Arrays.asList("Date       || Credit || Debit || Balance", "      --- End of Statement---"));


    public void deposit(Integer amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String stringDate = String.valueOf(formatter.format(date));
        Balance += amount;
        String entry = stringDate + " ||  " + String.valueOf(amount) + "  ||   -   || " + String.valueOf(Balance);
        statement.add(1, entry);
    }

    public void withdraw(Integer amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String stringDate = String.valueOf(formatter.format(date));
        Balance -= amount;
        String entry = stringDate + " ||    -   ||  " + String.valueOf(amount) + "  || " + String.valueOf(Balance);
        statement.add(1, entry);
    }

    public String generateStatement() {
        String[] elements = null;
        elements = statement.toArray(new String[statement.size()]);
        for (int i = 0; i < statement.size(); i++) {
            elements[i] = statement.get(i);
        }
        String statementString = String.join("\n", elements);
        return statementString;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(2000);
        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        System.out.println(bankAccount.generateStatement());
    }

}
