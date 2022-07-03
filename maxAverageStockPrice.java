import java.util.*;

public class maxAverageStockPrice {
    public static void main(String[] args) {
        maxAverageStockPrice a = new maxAverageStockPrice();
        int[] test = {1,2,2,2,3,4,2,3,4,1,2,3,4};
        System.out.println(a.max(test, 4));
        System.out.println(a.max(test, 5));
    }
    private int max(int[] prices, int k){
        int result = -1;
        int count = 0;
        int candidate = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<prices.length; i++){
            if (set.add(prices[i])) {
                count++;
                candidate += prices[i];
            } else {
                set.clear();
                set.add(prices[i]);
                candidate = prices[i];
                count = 1;
            }
            if(count > k){
                candidate -= prices[i-k];
                set.remove(prices[i-k]);
                count--;
            }
            if(count == k){
                result = Math.max(candidate, result);
            }
        }
        return result;
    }
}
