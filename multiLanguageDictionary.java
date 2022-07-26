import java.util.*;
public class multiLanguageDictionary {
    Map<String, Map<String, String>> masterMap;
    Map<String, String> rootMap;

    public static void main(String[] args) {
        multiLanguageDictionary test = new multiLanguageDictionary();
        test.add("Chinese", "Nihao", "English", "Hello");
        test.add("Spanish", "Hola", "English", "Hello");
        String s = test.get("Chinese", "Nihao", "Spanish");
        System.out.println(s);
    }

    multiLanguageDictionary(){
        masterMap = new HashMap<>();
        rootMap = new HashMap<>();
    }

    public void add(String l1, String w1, String l2, String w2){
        addHelper(l1, w1);
        addHelper(l2, w2);
        String root1 = find(w1);
        String root2 = find(w2);
        if(root1.equals(root2)){
            return;
        }
        union(w1, w2);
    }

    private void addHelper(String l, String w){
        String cur = rootMap.get(w);
        if(cur!=null){
            return;
        }
        rootMap.put(w, w);
        Map<String, String> curMap = new HashMap<>();
        curMap.put(l, w);
        masterMap.put(w, curMap);
    }

    private String find(String w){
        String s = rootMap.get(w);
        if(w.equals(s)){
            return s;
        }
        rootMap.put(w, find(s));
        return rootMap.get(w);
    }

    private void union(String w1, String w2){
        rootMap.put(w1, w2);
        masterMap.get(w2).putAll(masterMap.get(w1));
        masterMap.remove(w1);
    }

    public String get(String sl, String sw, String tl){
        String root = rootMap.get(sw);
        if(root == null){
            return "Can not find this word in system";
        }
        return masterMap.get(root).get(tl);
    }
}
