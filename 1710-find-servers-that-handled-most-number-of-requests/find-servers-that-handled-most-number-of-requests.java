
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // {completionTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];
        int max = 0;

        for (int i = 0; i < arrival.length; i++) {

            // Free completed servers
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                int[] curr = busy.poll();
                available.add(curr[1]);
            }

            // Drop request if all servers are busy
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server
            int preferred = i % k;

            // Find next available server
            Integer server = available.ceiling(preferred);

            // Wrap around
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;
            max = Math.max(max, count[server]);

            // Calculate completion time
            busy.offer(new int[]{
                arrival[i] + load[i], server
            });
        }

        // Collect busiest servers
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
