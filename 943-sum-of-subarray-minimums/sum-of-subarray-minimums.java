class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1_000_000_007;
        int[] NSE_arr = NSE(arr);
        int[] PSE_arr= PSE(arr);
        long total = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            int left = i - PSE_arr[i];
            int right = NSE_arr[i] - i;
            // total += (left* rigth) * arr[i];
            long contrib = ((long)arr[i] * left * right) % MOD;
            total = (total + contrib) % MOD;
        }
        return (int)total;
     }
    public int[] NSE(int [] arr){
        int n = arr.length;
        int[] NSE_arr = new int [n];
        Stack<Integer> s = new Stack<>();
        for(int i =  n -1; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()]>= arr[i]){
                s.pop();
            }
            NSE_arr[i] = s.isEmpty() ?n  : s.peek();
            s.push(i);
        }
        return NSE_arr;

    }
    public int[] PSE(int [] arr){
        int n = arr.length;
        int[] PSE_arr = new int [n];
        Stack <Integer> s = new Stack<>(); 
        for(int i = 0 ;  i < n ; i++ ){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }
            PSE_arr[i] = s.isEmpty() ? - 1: s.peek();
            s.push(i); 
        }
        return PSE_arr;
    }
}
