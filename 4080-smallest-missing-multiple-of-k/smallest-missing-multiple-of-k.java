class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;
        for(int i  : nums){
            max = Math.max(max , i);
            set.add(i);
        }
        int i = 1;
        while(i*k<= 100){
            if(!set.contains(i*k)) return i*k;
            i++;
        }
        return (i)*k; 
        
    }
}