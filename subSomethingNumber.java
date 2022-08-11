import java.util.*;

public class subSomethingNumber {
    char[] c = {'1', '6', '8', '9', '0'};
    public static void main(String[] args) {
        subSomethingNumber a = new subSomethingNumber();
        System.out.println(a.findAnswer(1));
        System.out.println(a.findAnswer(2));
        System.out.println(a.findAnswer(3));
    }
    private List<Integer> findAnswer(int n){
        List<Integer> ans = new ArrayList<>();
        char[] arr = new char[n];
        dfs(ans, arr,0, n);
        return ans;
    }

    private void dfs(List<Integer> ans, char[] arr, int index, int n) {
        if(index > (n-1)/2){
            for(int i = index; i<n;i++){
                if(arr[n - i - 1] == '6'){
                    arr[i] = '9';
                } else if(arr[n - i - 1] == '9'){
                    arr[i] = '6';
                } else {
                    arr[i] = arr[n - i - 1];
                }
            }
            ans.add(Integer.valueOf(new String(arr)));
            return;
        }
        for(char cur: c){
            arr[index] = cur;
            if(index == 0 && cur == '0' && n > 1){
                continue;
            }
            if(n%2!=0 && index == n/2 && (cur == '6' || cur == '9')){
                continue;
            }
            dfs(ans, arr, index+1, n);
        }
    }
}
