// class Solution {
//     public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
//         long ans = 0;
//         int IndiviSum= cost1 + cost2;
        
//         if(IndiviSum > costBoth){
//             if((costBoth < cost1 && costBoth < cost2) || costBoth == cost1 || costBoth == cost2){
//                 ans += (long)Math.max(need2 , need1) * costBoth;
//                 return ans;
//             }
//             else{
//                 int MinBoth = Math.min(need1 , need2);
//                 ans  += MinBoth * costBoth;
//                 need1 -= MinBoth;
//                 need2 -= MinBoth;
//             }
//         }
//         // System.out.println(ans + "  " + need1 + " " + need2);

//         ans +=(long)need1 * cost1;
//         ans += (long)need2 * cost2;

//         return ans;

//     }
// }

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        return Math.max(bound(need1, cost1, need2, cost2, costBoth), bound(need2, cost2, need1, cost1, costBoth));
    }

    private long bound(long needA, int costA, long needB, int costB, int costBoth) {
        int pA = Math.min(costA, costBoth);  // a takes its full price
        int pB = Math.min(costB, costBoth - pA);  // b gets what's left of the bundle
        return needA * pA + needB * pB;
    }
}