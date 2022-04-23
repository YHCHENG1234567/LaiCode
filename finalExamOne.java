import java.util.*;

//I assume 01 is valid input to generate letter A
public class finalExamOne {
    public List<String> decodingString(String input){
        List<String> result = new ArrayList<>();
        if(input == null){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, input, 0, result);
        return result;
    }
    private void dfs(StringBuilder sb, String input, int cur, List<String> result){
        if(cur == input.length()){
            result.add(sb.toString());
            return;
        }
        if(cur < input.length()-1){
            int number = (input.charAt(cur) - '0') * 10 + (input.charAt(cur+1)  - '0');
            if(number >= 1 && number <= 26){
                sb.append((char)(number - 1 + 'A'));
                dfs(sb, input, cur+2, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(cur < input.length()){
            int number2 = input.charAt(cur)  - '0';
            if(number2 >= 1 && number2 <= 9){
                sb.append((char)(number2 - 1 + 'A'));
                dfs(sb, input, cur+1, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        finalExamOne a = new finalExamOne();
        String s = "1234567";
        System.out.println(a.decodingString(s));
    }
}