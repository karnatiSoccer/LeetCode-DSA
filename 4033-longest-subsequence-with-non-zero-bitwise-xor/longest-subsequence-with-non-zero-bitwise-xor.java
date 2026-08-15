// class Solution {
//     Integer[][] dp;
//     private static final int MAX_XOR = 8192;
    
//     public int longestSubsequence(int[] nums) {
//         int n= nums.length;

//         dp = new Integer[n][MAX_XOR];

//         int ans = helper(nums , nums.length-1, 0);
//         return ans < 0 ? 0 : ans;

//     }

//     public int helper(int[] nums , int idx , int xor){
//         if(idx < 0 ){
//             return ( xor != 0) ? 0 : Integer.MIN_VALUE / 2;
//         }
//         // int taken;
        
//         if(dp[idx][xor] != null) return dp[idx][xor];

//         int taken = 1+ helper(nums , idx-1 , xor^nums[idx]);
        
//         int notTaken = helper(nums , idx-1 , xor);

//         return dp[idx][xor] =  Math.max(taken , notTaken);
//     }
// }


class Solution {
    // Integer[][] dp;
    // private static final int MAX_XOR = 8192;
    
    public int longestSubsequence(int[] nums) {
        boolean hasNonZero = false;
        int totalXor = 0;
        for(int num: nums){
            totalXor ^= num;
            if(num  !=0){
                hasNonZero = true;
            }

        }

        if(totalXor != 0) return nums.length;

        if(!hasNonZero) return 0;

        return nums.length-1;

    }

}