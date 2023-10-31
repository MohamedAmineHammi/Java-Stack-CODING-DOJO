public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        System.out.println("New account Created Number : " + account1.getAccountNumber());

        account1.depositMoney(500, 250);
        account1.withdrawMoney(100, 50);
        account1.getTotalAmount();

    }

}
