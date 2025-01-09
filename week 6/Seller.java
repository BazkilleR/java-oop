public class Seller extends Employee {

    public Food sell(Employee e) {
        Food food = new Food();
        double foodPrice = Food.getPrice();
        Wallet buyerWallet = e.getWallet();
        Wallet sellerWallet = this.getWallet();

        if (buyerWallet.getBalance() >= foodPrice) {
            sellerWallet.setBalance(sellerWallet.getBalance() + foodPrice);
            buyerWallet.setBalance(buyerWallet.getBalance() - foodPrice);
            return food;
        } else {
            System.out.println("Your money is not enough.");
            return null;
        }
    }
}
