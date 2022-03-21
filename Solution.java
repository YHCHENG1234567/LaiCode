public class Solution {
    public static void main(String[] args) {
        String a = "aaaaaabbabb";
        Solution B = new Solution();
        int c = B.minCuts(a);
        System.out.print(c);
    }
    public int minCuts(String input) {
        if(input.length()<=1) return 0;
        int[] M = new int[input.length()+1];
        M[0] = 0;
        for(int i = 0; i<input.length(); i++){
            int minPN = input.length();
            for(int j = 0; j<=i; j++){
                if(isPalindromes(input, j, i)){
                    int palinNumber = M[j] + 1;
                    minPN = Math.min(minPN, palinNumber);
                }
            }
            M[i+1] = minPN;
        }
        return M[input.length()] -1;
    }
    //   if(input.length()<=1) return 0;
    //   return helper(input, 0, input.length()-1);
    // }
    // public int helper(String input, int start, int end){
    //   if(isPalindromes(input, start, end)) return 0;
    //   int minCut = end-start;
    //   for(int cutPoint = start; cutPoint<end; cutPoint++){
    //     int cut = helper(input, start, cutPoint) + helper(input, cutPoint+1, end) + 1;
    //     minCut = Math.min(cut, minCut);
    //   }
    //   return minCut;
    // }
    public boolean isPalindromes(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}