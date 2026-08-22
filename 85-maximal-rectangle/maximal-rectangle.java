class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '0') continue;
                else{
                    dp[i][j] = j == 0 ? 1 : 1 + dp[i][j-1];
                    
                    int width = dp[i][j];

                    for(int k = i ; k >= 0 ; k--){
                        width = Math.min(width, dp[k][j]);
                    
                        maxArea = Math.max(maxArea , width * (i - k + 1));
                    }

                }

            }
        }
        return maxArea;
    }
}