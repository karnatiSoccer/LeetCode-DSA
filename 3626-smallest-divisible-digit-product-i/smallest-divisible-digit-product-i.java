class Solution {
    public int smallestNumber(int n, int t) {
        
        while(prodDigit(n) % t != 0){
            n++;
        }
        return n;

    }
    public int prodDigit(int n){
        int prod = 1;
        while( n > 0){
            int digit = n % 10;
            prod *= digit;
            n /= 10;
        }
        return prod;
    }
}