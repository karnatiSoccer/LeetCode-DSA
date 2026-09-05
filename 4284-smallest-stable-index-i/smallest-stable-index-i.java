class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        int[] minVal = new int[nums.length];

        minVal[nums.length -1] = nums[nums.length-1];

        for(int i = nums.length-2 ; i >= 0 ; i--){
            minVal[i]= Math.min(nums[i] , minVal[i+1]);
        }

        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(nums[i] , max);
            int min = minVal[i];

            int instability = max - min;

            if(instability <= k) return i;
        }
        return -1;
    }
}