import java.util.Random;

public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingBalance;
    private long accountNumber;
    public static int numberOfAccounts = 0;
    public static double totalAmount = 0;

    
    private static int generateRandomAccountNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000000) + 999999999;
        return randomNumber;


    }

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingBalance = 0;
        this.accountNumber = BankAccount.generateRandomAccountNumber();
        numberOfAccounts++;

    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingBalance() {
        return this.savingBalance;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public void depositMoney(double checkingBalance, double savingBalance) {
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        totalAmount += checkingBalance;
        totalAmount += savingBalance;

    }

    public void withdrawMoney(double withdrawCheckingBalance, double withdrawSavingBalance) {
        if (checkingBalance >= withdrawCheckingBalance && savingBalance >= withdrawSavingBalance) {
            checkingBalance -= withdrawCheckingBalance;
            savingBalance -= withdrawSavingBalance;
            totalAmount -= withdrawSavingBalance;
            totalAmount -= withdrawCheckingBalance;

        }

        else {
            System.out.println("There are insufficient funds. !");

        }

    }

    public void getTotalAmount() {
        System.out.println("Checking balance amount : " + this.checkingBalance);
        System.out.println("Saving balance amount : " + this.savingBalance);
        System.out.println("total amount : " + totalAmount);

    }


}
