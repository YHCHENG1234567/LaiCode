import java.util.Arrays;

public class takeStone {

    public static void main(String[] args) {
        takeStone a = new takeStone();
        int[] test1 = {1,3,5,7};
        int[] test2 = {45,4,67,1,3};
        System.out.println(a.minTake(test1));
        System.out.println(a.minTake(test2));
    }
    private int minTake(int[] test){
        Arrays.sort(test);
        int minTake = Integer.MAX_VALUE;
        int frontTake = 0;
        int endTake = 0;
        for (int j : test) {
            endTake += j;
        }
        endTake -= test[0] * test.length;
        for(int i = 0; i<test.length-1; i++){
            frontTake += test[i];
            endTake -= (test.length - i - 1) * (test[i + 1] - test[i]);
            minTake = Math.min(minTake, frontTake + endTake);
        }
        return minTake;
    }
}