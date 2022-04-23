public class finalExamFour {
    public boolean isInfinite(String[] names) {
        if (names == null || names.length == 0) return true;
        return dfs(names, 0);
    }
    private boolean dfs(String[] names, int index){
        if(index == names.length){
            return isValid(names, index-1, 0);
        }
        for(int i = index; i<names.length; i++){
            if(isValid(names, index-1, i)){
                swap(names, index, i);
                if(dfs(names, index+1)) {
                    return true;
                }
                swap(names, index, i);
            }
        }
        return false;
    }
    private void swap(String[] names, int a, int b){
        String temp = names[a];
        names[a] = names[b];
        names[b] = temp;
    }
    private boolean isValid(String[] names, int a, int b){
        if(a<0) return true;
        return names[a].charAt(names[a].length()-1) == names[b].charAt(0);
    }

    public static void main(String[] args) {
        finalExamFour a = new finalExamFour();
        String[] test1 = {"ashlock","kira"};
        String[] test2 = {"blemishine","exusiai","ib"};
        String[] test3= {"surtr","nearl","silverash"};
        System.out.println(a.isInfinite(test1));
        System.out.println(a.isInfinite(test2));
        System.out.println(a.isInfinite(test3));
    }
}
