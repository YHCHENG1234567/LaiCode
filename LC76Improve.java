import java.util.*;

class LC76Improve {
    public static void main(String[] args) {
        LC76Improve m = new LC76Improve();
        String testS = "ADOBECODEBANCACB";
        String testT = "ABC";
        System.out.println(m.scoreSort(testS, testT, 7));
    }
    public List<String> scoreSort(String S, String T, int k){
        int[] countMap = new int[26];
        Arrays.fill(countMap, Integer.MIN_VALUE);
        for(int i = 0; i<T.length(); i++){
            int curIndex = (int)(T.charAt(i) - 'A');
            if(countMap[curIndex] == Integer.MIN_VALUE){
                countMap[curIndex] = 1;
            } else {
                countMap[curIndex]++;
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.equals(b))return -1;
                double aScore = findScore(a, countMap);
                double bScore = findScore(b, countMap);
                return aScore > bScore ? -1 : 1;
            }
        });
        for(int len = 1; len <= S.length(); len++){
            for(int startIndex = 0; startIndex <= S.length() - len; startIndex++){
                pq.offer(S.substring(startIndex, startIndex + len));
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i<k; i++){
            res.add(pq.poll());
        }
        return res;
    }
    private double findScore(String s, int[] countMap){
        double score = 1000D;
        int[] countMapCopy = new int[26];
        for(int i = 0; i<26; i++){
            countMapCopy[i] = countMap[i];
        }
        for(int i = 0; i<s.length(); i++){
            int curIndex = (int)(s.charAt(i) - 'A');
            if(countMapCopy[curIndex] > 0){
                countMapCopy[curIndex] --;
            } else if(countMapCopy[curIndex] == Integer.MIN_VALUE){
                score -= 0.015 * (int)(s.charAt(i) - 'A' + 1);
            } else if(countMapCopy[curIndex] == 0){
                score -= 0.01 * (int)(s.charAt(i) - 'A' + 1);
            }
        }
        for(int i = 0; i<26; i++){
            if(countMapCopy[i] > 0){
                score = Integer.MIN_VALUE;
            }
        }
        return score;
    }
}