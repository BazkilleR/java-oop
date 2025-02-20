package one;

public class Main {

    public static void main(String[] args) {
        Account acct1 = new Account(5000, "Sommai");
        Account acct2 = new Account(3000, "Somchai");
        Account acct3 = new Account(900, "Somsri");

        Bank myBank = new Bank();
        myBank.addAccount(acct1);
        myBank.addAccount(acct2);
        myBank.addAccount(acct3);

        System.out.println("Number of Account: " + myBank.getNumAccount());
        myBank.getAccount(0).showAccount();
        System.out.println("Deposit 500...");
        myBank.getAccount(0).deposit(500);
        myBank.getAccount(0).showAccount();
        System.out.println("Show all accounts");

        System.out.println("==============================");
        for (int i = 0; i < myBank.getNumAccount(); i++) {
            myBank.getAccount(i).showAccount();
        }
    }

}
