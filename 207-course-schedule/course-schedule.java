class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int pre = prerequisite[1];

            map.putIfAbsent(pre, new ArrayList<>());
            map.get(pre).add(course);

            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();
            count++;

            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    inDegree[next]--;

                    if (inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }

        return count == numCourses;
    }
}