class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        
        for(int[] edge: prerequisites) {
            int dep = edge[0];
            int indep = edge[1];
            
            indeg[dep] += 1;
            
            if(!map.containsKey(indep)) {
                map.put(indep, new ArrayList<>());
            }
            map.get(indep).add(dep);
            
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
                count++;
            }
        }
        
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> deps = map.get(cur);
            if(deps == null) continue;
            for(Integer dep: deps) {
                indeg[dep] -= 1;
                if(indeg[dep] == 0) {
                    q.add(dep);
                    count++;
                    if(count == numCourses) return true;
                }
            }
        }
        if(count == numCourses) return true;
        return false;
        
    }
}