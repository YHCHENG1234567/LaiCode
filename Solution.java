public class Solution {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,1,1}, {1,0,1},{1,1,1}};
        Solution B = new Solution();
        int c = B.largestSquareSurroundedByOne(a);
        System.out.print(c);
    }
    public int largestSquareSurroundedByOne(int[][] matrix) {
        int M = matrix.length;
        if(M==0) return 0;
        int N = matrix[0].length;
        if(N==0) return 0;
        int[][] left = new int[M][N];
        int[][] up = new int[M][N];
        int[][] result = new int[M][N];
        leftUp(matrix, left, up, M, N);
        merge(result, left, up, M, N);
        int max = 0;
        for(int i=M-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                for(int k = result[i][j]; k>=1; k--){
                    if(up[i][j-k+1]>=k && left[i-k+1][j]>=k){
                        max = Math.max(max, k);
                        break;
                    }
                }
            }
        }
        return max;
    }
    public void leftUp(int[][] matrix, int[][] left, int[][] up, int M, int N){
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j]==1){
                    if(i==0 && j==0){
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else if (i==0){
                        left[i][j] = left[i][j-1] + 1;
                        up[i][j] = 1;
                    } else if (j==0){
                        left[i][j] = 1;
                        up[i][j] = up[i-1][j] + 1;
                    } else {
                        left[i][j] = left[i][j-1] + 1;
                        up[i][j] = up[i-1][j] + 1;
                    }
                }
            }
        }
    }
    public void merge(int[][] result, int[][] a, int[][] b, int N, int M){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                result[i][j] = Math.min(a[i][j], b[i][j]);
            }
        }
    }
}