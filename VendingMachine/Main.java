package VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine v = new VendingMachine();
        v.addItem("Evian", 11, 10);
        v.addItem("Perrier", 6, 8);
        v.addItem("Perrier", 5, 2);
        v.addItem("Waterloo", 5, 10);

        v.pay(100);
        v.showItems();

        v.buyItem("Evian", 2);
        v.buyItem("Perrier", 5);
        v.buyItem("Waterloo", 1);

        v.showRemainCash();

        v.showItems();
        v.refund();

        v.getIncome();
    }
}
