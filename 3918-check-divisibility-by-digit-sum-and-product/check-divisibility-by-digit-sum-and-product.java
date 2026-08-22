class Solution {
    public boolean checkDivisibility(int n) {
        int N = n;
        int sum = 0;
        int prod =1;
        while(N > 0){
            int digit = N % 10;
            sum += digit;
            prod *= digit;
            N/=10;
        }   
        // System.out.println(sum + " " + prod);
        return n % (sum+prod )==0;
    }
}