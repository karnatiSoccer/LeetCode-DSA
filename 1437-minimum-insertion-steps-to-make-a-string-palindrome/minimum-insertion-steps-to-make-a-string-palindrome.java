class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int x = helper(s , rev, s.length()-1 , s.length()-1);
        return s.length() - x ;
    }

    public int helper(String s1 , String s2 , int idx1 , int idx2){
        int m = s1.length();
        int n = s2.length();
        Integer[][] dp =new Integer[m+1][n+1];


        for(int i= 0 ; i < m ; i++){
            dp[i][0]= 0;
        }
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= m; ind1++) {
            for (int ind2 = 1; ind2 <= n; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } 
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[m][n];
        
    }

}