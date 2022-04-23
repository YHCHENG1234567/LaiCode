import java.util.*;

public class finalExamThree{
    public int minNumberOfBox(int n){
        if(n<=0) return 0;
        int[] M = new int[n+1];
        M[0] = 0;
        for(int i = 1; i<= n; i++){
            if(isSquare(i)){
                M[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j = 1; j * j<= i; j++){
                    min = Math.min(min, M[i - j * j] + 1);
                }
                M[i] = min;
            }
        }
        return M[n];
    }
    private boolean isSquare(int i){
        int a = (int)(Math.sqrt(i));
        return a * a == i;
    }
    public static void main(String[] args) {
        finalExamThree a = new finalExamThree();
        System.out.println(a.minNumberOfBox(9));
        System.out.println(a.minNumberOfBox(87));
        System.out.println(a.minNumberOfBox(654));
        System.out.println(a.minNumberOfBox(3210));
    }
}
