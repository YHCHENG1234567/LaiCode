public class PrimeMovieAward {
    public static void main(String[] args) {
        int[][] test = {{0, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 1},{1, 1, 0, 0, 1, 1}};
        PrimeMovieAward p = new PrimeMovieAward();
        System.out.println(p.grey(test));
    }

    private int grey(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] DPm = new int[m];
        int[] DPn = new int[n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    DPm[i]--;
                    DPn[j]--;
                } else {
                    DPm[i]++;
                    DPn[j]++;
                }
            }
        }
        for(int i: DPm){
            System.out.print(i + ", ");
        }
        System.out.println();
        for(int i: DPn){
            System.out.print(i + ", ");
        }
        System.out.println();
        int res = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    int cur = Math.abs(DPm[i] + DPn[j] + 1);
                    if(cur > res){
                        res = cur;
                    }
                } else {
                    int cur = Math.abs(DPm[i] + DPn[j] - 1);
                    if(cur > res){
                        res = cur;
                    }
                }
            }
        }
        return res;
    }
}


//input
// k = 3
//[1,3,4,6,7,8,9]
// i
// The difference between max and min of each group can not exceed k
//

//Output: int (minimum number of groups)
//m = 3, n = 6
//[0 1 1 1 1 0]
//[0 0 0 1 0 1]
//[1 1 0 0 1 1]

//int[] DPm = new int[m]
//int[] DPn = new int[n]