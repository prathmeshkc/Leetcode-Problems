class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> deps = new HashMap<>();
        int[] indegree = new int[numCourses];
        
//         fill the indegree array and create the deps map
        for(int[] edge: prerequisites) {
            int dep = edge[0];
            int inDep = edge[1];
            indegree[dep]++;
            if(!deps.containsKey(inDep)) {
                deps.put(inDep, new ArrayList<>());
            }
            deps.get(inDep).add(dep);
        }
        
        Queue<Integer> q = new LinkedList<>();
// count to check how many courses are we able to complete so we can tally with numCourses
        int count = 0;
        for(int i = 0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty()) {
            int inDep = q.poll();
            List<Integer> dependants = deps.get(inDep);
            if(dependants == null) continue;
            for(int dep: dependants) {
                indegree[dep]--;
                if(indegree[dep] == 0) {
                    q.add(dep);
                    count++;
                    if(count == numCourses) return true;
                }
            }
        }
        
        
        return false;
        
        
    }
}