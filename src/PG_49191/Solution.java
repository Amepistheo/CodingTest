// 49191번 순위
package PG_49191;

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for (int[] game : results) {
            win.get(game[0]).add(game[1]);
            lose.get(game[1]).add(game[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            boolean[] winVisit = new boolean[n + 1];
            boolean[] loseVisit = new boolean[n + 1];
            
            int winCount = bfs(i, win, winVisit);
            int loseCount = bfs(i, lose, loseVisit);
            
            if ((winCount + loseCount) == (n - 1)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int bfs(int x, List<List<Integer>> graph, boolean[] isVisit) {        
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        isVisit[x] = true;
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int i = 0; i < graph.get(node).size(); i++) {
                int child = graph.get(node).get(i);
                
                if (isVisit[child]) {
                    continue;
                }
                
                q.offer(child);
                isVisit[child] = true;
                
                count++;
            }
        }
        
        return count;
    }
}