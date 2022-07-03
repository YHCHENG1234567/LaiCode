import java.util.*;
class nineKeyPad {
    public static void main(String[] args) {
        nineKeyPad a = new nineKeyPad();
        String test1 = "abcdefghijjj"; //13
        String test2 = "abcdefghijklmnopqrstuvwxyzzz";//53
        String test3 = "woshiyeyuanxinzhizhuwusui";//28 我是野原新之助 五岁
        System.out.println(a.findPressTime(test1));
        System.out.println(a.findPressTime(test2));
        System.out.println(a.findPressTime(test3));
    }
    private int findPressTime(String input){
        char[] a = input.toCharArray();
        Integer[] countMap = new Integer[26];
        Arrays.fill(countMap, 0);
        for(int i = 0; i<a.length; i++){
            countMap[a[i] - 'a']++;
        }
        Arrays.sort(countMap, Collections.reverseOrder());
        int res = 0;
        for(int j = 0; j<26; j++){
            if(j<=8){
                res+=countMap[j];
            } else if(j<=17){
                res+=countMap[j]*2;
            } else {
                res+=countMap[j]*3;
            }
        }
        return res;
    }
}