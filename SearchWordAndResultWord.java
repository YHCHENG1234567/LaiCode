
public class SearchWordAndResultWord {
    public static void main(String[] args) {
        SearchWordAndResultWord a = new SearchWordAndResultWord();
        String test1s = "armaze";
        String test1t = "amazon";
        System.out.println(a.addLetter(test1s, test1t));
        String test2s = "woshiyeyuanxinzhizhuwusui";//我是野原新之助五岁
        String test2t = "woshifengjian";//我是风间
        System.out.println(a.addLetter(test2s, test2t));
        String test3s = "laiwanbanjiajiajiuba";//来玩扮家家酒吧
        String test3t = "jiajiajiu";//家家酒
        System.out.println(a.addLetter(test3s, test3t));
    }
    private int addLetter(String search, String target){
        int i = 0;
        int j = 0;
        while(i<search.length()){
            if(j<target.length() && search.charAt(i) == target.charAt(j)){
                i++;
                j++;
            } else if(j == target.length()){
                return 0;
            } else {
                i++;
            }
        }
        return target.length() - j;
    }
}
