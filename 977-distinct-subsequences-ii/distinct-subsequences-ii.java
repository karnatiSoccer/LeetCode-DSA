// class Solution {
//     HashSet<String> hash;
    
//     Integer[][] dp;
//     public int distinctSubseqII(String s) {
//         hash = new HashSet<>();
//         dp = new Integer[s.length()][2];
//         return  helper(s , new StringBuilder() , 0)-1;
//     }

//     public int helper(String s , StringBuilder sb , int idx){
//         if(idx == s.length()){
//             String SubSeq = sb.toString();
//             if(!hash.contains(SubSeq) ){
//                 hash.add(SubSeq);
//                 return 1;
//             }else{
//                 return 0;
//             }
//         }

//         int taken =0;
//         sb.append(s.charAt(idx));
//         taken += helper(s ,sb , idx+1);
//         sb.deleteCharAt(sb.length()-1);
//         int noTaken=0;
//         noTaken += helper(s , sb , idx+1);
//         return taken + noTaken; 
//     }
// }


class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endsWith = new long[26];

        for (char ch : s.toCharArray()) {
            long total = 0;
            for (int i = 0; i < 26; i++) total = (total + endsWith[i]) % MOD;
            endsWith[ch - 'a'] = (total + 1) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < 26; i++) ans = (ans + endsWith[i]) % MOD;
        return (int) ans;
    }
}