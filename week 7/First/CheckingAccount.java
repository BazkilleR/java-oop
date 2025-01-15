
public class CheckingAccount extends Account {

    private double credit;

    public CheckingAccount() {
        super(0, "");
        this.credit = 0;
    }

    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.credit = credit;
    }

    public void setCredit(double credit) {
        if (credit > 0) {
            this.credit = credit;
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public double getCredit() {
        return this.credit;
    }

    @Override
    public void withdraw(double a) {
        if (a < 0) {
            System.out.println("Input number must be a positive integer.");
            return;
        }

        if ((this.balance - a) >= 0) {
            this.balance -= a;
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit);
        } else if (((this.balance - a) < 0) && ((this.balance - a + this.credit) >= 0)) {
            setBalance(0);
            setCredit(this.credit + (this.balance - a));
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit);
        } else if (((this.balance - a) < 0) && ((this.balance - a + this.credit) < 0)) {
            System.out.println("Not enough money!");
        }
    }

    public void withdraw(String a) {
        double doubleValue = Double.parseDouble(a);
        this.withdraw(doubleValue);
    }

    @Override
    public String toString() {
        return "The " + name + " account has " + balance + " baht and " + credit + " credits.";
    }
}
