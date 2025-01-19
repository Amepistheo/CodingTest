// 86971번 전력망을 둘로 나누기
package PG_86971;

import java.io.*;
import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] isVisit;
    static Queue<Integer> resultQ;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            graph = new ArrayList<>();
            isVisit = new boolean[n + 1];
            resultQ = new LinkedList<>();

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }

                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }

            search(n);

            answer = Math.min(answer, Math.abs(resultQ.poll() - resultQ.poll()));
        }

        return answer;
    }

    private void search(int n) {
        for (int i = 1; i <= n; i++) {
            if (isVisit[i]) {
                continue;
            }

            resultQ.offer(bfs(i));
        }
    }

    private int bfs(int x) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        isVisit[x] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int node2 = graph.get(node).get(i);

                if (isVisit[node2]) {
                    continue;
                }

                q.offer(node2);
                isVisit[node2] = true;
                count++;
            }
        }

        return count;
    }
}