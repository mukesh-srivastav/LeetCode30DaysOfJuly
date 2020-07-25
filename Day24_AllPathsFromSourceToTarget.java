/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
import java.util.*;
class Day24_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        
        int n = graph.length;
        
        if (n == 0)
            return res;
        
        List<Integer> curr = new LinkedList<>();
        dfs(graph, 0, res, curr);
        
        return res;
    }
    
    private void dfs(int[][] graph, int source, List<List<Integer>> res, List<Integer> curr)
    {
        curr.add(source);
        if (source == graph.length - 1) {
            res.add(curr);
            return;
        }
        
        for (int i : graph[source]) {
            List<Integer> clone = new LinkedList<>(curr);
            dfs(graph, i, res, clone);
        }
    }
}