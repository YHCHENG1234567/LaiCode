import java.util.*;

//给一个Integer array 和一个限定长度k, 取一个长度为k的subarray， 要求subarray中没有重复的数字。求符合的subarray最大各位数和。若没有符合条件的subarray, return-1

//[1 7 2 7 4 3 6]
//   -----
//   s
//       f
//Set: [7 2] size:2

//取最大
// int max = 0;
// int cur = 0;
// max = Math.max(cur, max);
//不含重复
//Map<Integer> map
//key = 7 value = 1 第一次出现index
//if(!set.add(input[i]))
//  count = 0, cur = 0, set.clear
//  count = 1, cur = 7, set.add(7)
//限制选取长度
// int count = 0;
// if (count == 3)

//127, 743, 436
// 10,  14,  13
//长度：3
// return 选取段的和
// return -1;

public class maxAverageStockPrice {
    public static void main(String[] args) {
        maxAverageStockPrice a = new maxAverageStockPrice();
        int[] test = {1,7,2,7,4,3,6};
        System.out.println(a.max(test, 3)); // 7+4+3 = 14
        System.out.println(a.max(test, 4)); // 7+4+3+6 = 20
    }
    private int max(int[] prices, int k){
        int result = -1; //初始化结果，若没有符合条件的Selected range, return -1
        Set<Integer> set = new HashSet<>(); //记录Selected range里包含的所有数字，查重
        int count = 0; //Selected range 长度
        int curSum = 0; //Selected range 总和
        int slow = 0; //Selected range起始点（inclusive）
        //i is fast pointer. Selected range is between slow and faster pointer, inclusively.
        for(int i = 0; i<prices.length; i++){
            //set里已经含有当前数时，slow pointer往前移，直到移过重复数字。
            if(set.contains(prices[i])){
                while(prices[slow]!=prices[i]){
                    set.remove(prices[slow]);
                    curSum -= prices[slow];
                    slow++;
                    count--;
                }
                curSum -= prices[slow];
                slow++;
                count--;
            }
            //当selected range长度已经达到K时，slow pointer往前移一位
            if(count == k){
                curSum -= prices[slow];
                set.remove(prices[slow]);
                slow++;
                count--;
            }
            //前移快指针操作
            curSum += prices[i];
            count++;
            set.add(prices[i]);
            //当selected range为K时，更新result
            if(count == k){
                result = Math.max(curSum, result);
            }
        }
        return result;
    }
}
