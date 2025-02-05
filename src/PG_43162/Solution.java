// 43162번 네트워크
package PG_43162;

import java.util.*;

class Solution {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisit;

    public int solution(int n, int[][] computers) {
        isVisit = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (computers[i][j] == 0) {
                    continue;
                }

                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }

        return search(n);
    }

    private int search(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isVisit[i]) {
                continue;
            }

            bfs(i);
            count++;
        }

        return count;
    }

    private void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        isVisit[x] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i = 0; i < graph.get(poll).size(); i++) {
                int node = graph.get(poll).get(i);

                if (isVisit[node]) {
                    continue;
                }

                q.offer(node);
                isVisit[node] = true;
            }
        }
    }
}