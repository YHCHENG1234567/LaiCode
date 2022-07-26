package VendingMachine;

import java.util.*;

public class VendingMachine {
    Map<String, Integer> numberMap;
    Map<String, Integer> priceMap;
    int cashInput;
    int income;

    VendingMachine(){
        numberMap = new HashMap<>();
        priceMap = new HashMap<>();
        cashInput = 0;
        income = 0;
    }

    public void addItem(String product, int price, int number){
        if(numberMap.containsKey(product)){
            int a = numberMap.get(product);
            numberMap.put(product, a + number);
        } else {
            numberMap.put(product, number);
        }
        priceMap.put(product, price);
    }

    public void clearMachine(){
        numberMap.clear();
        priceMap.clear();
    }

    public void pay(int cash){
        this.cashInput+=cash;
        System.out.println("Insert " + cash + " dollars into Vending machine successful!");
    }

    public void showRemainCash(){
        System.out.println("The remainig cash is " + this.cashInput + " dollars.");
    }

    public void showItems(){
        System.out.println("Current Inventory: ");
        for(Map.Entry<String, Integer> cur: numberMap.entrySet()){
            System.out.println("      " + cur.getValue() + " * " + cur.getKey() + ". Priced at " + priceMap.get(cur.getKey()) + " dollars each.");
        }
    }

    public void getIncome(){
        System.out.println("Income so far: " + this.income + " dollars");
    }

    public boolean buyItem(String product, int number){
        Integer availableNumber = numberMap.get(product);
        if(availableNumber == null || availableNumber < number){
            throw new RuntimeException("Supply of this product is not sufficient enough to cover current purchase request.");
        }
        int moneyNeeded = number * priceMap.get(product);
        if(cashInput < moneyNeeded){
            throw new RuntimeException("Cash is not sufficient. Please put in more cash");
        }
        cashInput -= moneyNeeded;
        this.income += moneyNeeded;
        if(availableNumber == number){
            numberMap.remove(product);
            priceMap.remove(product);
        } else {
            int newNumber = availableNumber - number;
            numberMap.put(product, newNumber);
        }
        System.out.println("Purchase Successful");
        System.out.println("   You get " + number + " " + product + ".");
        System.out.println("   " + moneyNeeded + " dollars spent.");
        return true;
    }

    public int refund(){
        int temp = this.cashInput;
        cashInput = 0;
        System.out.println("Refund Successful. You get " + temp + " dollars.");
        return temp;
    }
}
