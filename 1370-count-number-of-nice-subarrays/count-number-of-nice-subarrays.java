class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // int maxLen = 0;
        return cntAtmost(nums, k) -cntAtmost(nums , k-1);
    }
    public int cntAtmost(int[]nums ,int k){
        int i = 0;
        int res = 0;

        for(int j = 0; j < nums.length ; j++){
            int curr =  nums[j];
            if(curr % 2 != 0) k--;
            while(k < 0){
                if(nums[i] % 2 == 1) k++;
                i++;
            }
            res += j-i+1;
            // maxLen = Math.max(maxLen  , j-i+1);
        }
        return res;
    }
}