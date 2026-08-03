class Solution {

    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        
        int ans =  helper(0 ,  stoneValue);
        
        System.out.println(ans);
        
        return (ans > 0) ? "Alice" : (ans == 0) ? "Tie" : "Bob";
    }

    public int helper( int idx , int[] stoneValue){
      
        if(idx >= stoneValue.length) return 0;

        if(dp[idx] != null) return dp[idx];
        
        int max = Integer.MIN_VALUE;
        
        int sum = 0;

        for(int i = idx ; i < Math.min(stoneValue.length, idx  + 3) ; i++){
            sum += stoneValue[i];
            int curr1 =  sum - helper(i+1 ,stoneValue );

            max = Math.max(curr1 , max);
   
        }
        return dp[idx] = max;
    }
}