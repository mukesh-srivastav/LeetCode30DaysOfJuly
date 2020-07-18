/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
import java.util.*;
public class Day18_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph and indegree array
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        int[] order = new int[numCourses];
        int index = 0;

        // Initialize queue and add all courses having indegree 0
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                queue.add(i);
                order[index++] = i;
            }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int c : graph[current]) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    queue.add(c);
                    order[index++] = c;
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}