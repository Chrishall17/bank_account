package bank_account;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountTest {
    @Test
    public void callingInitialBalanceReturnsBlankStatement() {
        BankAccount bankAccount = new BankAccount();
        String actual = bankAccount.generateStatement();
        Assert.assertEquals("Date       || Credit || Debit || Balance\n" +
                "      --- End of Statement---", actual);
    }

    @Test
    public void callingInitialBalanceReturnsStatementWithDepositsAndWithdrawals() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(2000);
        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        String actual = bankAccount.generateStatement();
        Assert.assertEquals("Date       || Credit || Debit || Balance\n" +
                "17/04/2023 ||    -   ||  500  || 2500\n" +
                "17/04/2023 ||  1000  ||   -   || 3000\n" +
                "17/04/2023 ||  2000  ||   -   || 2000\n" +
                "      --- End of Statement---", actual);
    }


}
