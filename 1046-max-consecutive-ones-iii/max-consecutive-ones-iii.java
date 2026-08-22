class Solution {
    public int longestOnes(int[] nums, int k) {
       int i = 0;
        int max = 0;
        int currFreq = 0;
       for(int j  = 0 ; j < nums.length ; j++){
            if(nums[j] == 1)currFreq++;

            while((j-i+1) - currFreq > k){
                if(nums[i] == 1)currFreq--;
                i++;
            }
            max = Math.max(max , j-i+1);
       }
       return max;
    }
}