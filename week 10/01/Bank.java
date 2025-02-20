package one;

public class Bank {

    private Account acct[];
    private int numAcct;

    public Bank() {
        this.acct = new Account[10];
    }

    public void addAccount(Account ac) {
        this.acct[numAcct] = ac;
        numAcct++;
    }

    public Account getAccount(int index) {
        return acct[index];
    }

    public int getNumAccount() {
        return numAcct;
    }
}
