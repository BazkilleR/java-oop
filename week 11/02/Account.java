package two;

public class Account {

    protected double balance;
    protected String name;

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void deposit(double a) {
        if (a > 0) {
            this.balance += a;
            System.out.println(a + " baht is deposited to " + this.name + ".");
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public void withdraw(double a) throws WithdrawException {
        if (a > 0) {
            if (balance - a > 0) {
                this.balance -= a;
                System.out.println(a + " baht is withdrawn from " + this.name + ".");
            } else {
                throw new WithdrawException("“Account " + name + " has not enough money.");
            }

        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void showAccount() {
        System.out.println(this.name + " account has " + this.balance + " baht.");
    }
}
