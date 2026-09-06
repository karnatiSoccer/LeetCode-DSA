// class Solution {
//     public int numDistinct(String s, String t) {
//         return helper(s , t , 0 , new StringBuilder() );
//     }
//     public int helper(String  s , String t , int idx , StringBuilder sb ){
//         if(sb.length() == t.length()){
//             if(sb.toString().equals(t)) return 1;
//             else return 0;
//         }
//         if(idx == s.length()){
//             return 0;
//         }

//         sb.append(s.charAt(idx));
//         int taken = helper(s , t , idx+1 , sb);
//         sb.deleteCharAt(sb.length()-1);
//         int noTaken = helper(s , t , idx+1, sb);
//         return noTaken + taken;
//     }
// }


class Solution {

    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];

        return helper(s , t , 0 ,  0);
    }

    public int helper(String s , String t , int i , int j){

        if(j == t.length())return 1;
        if(i == s.length())return 0;


        if(dp[i][j] != null)return dp[i][j];
        

        int take= 0;
        int noTaken = 0;
        if(s.charAt(i) ==  t.charAt(j)){
            take += helper(s , t , i+1 , j+1);
            take += helper(s , t , i+1 , j);
        }
        else{
            noTaken = helper(s , t ,i+1 , j);
        }
        return dp[i][j] = take + noTaken;
    }
}