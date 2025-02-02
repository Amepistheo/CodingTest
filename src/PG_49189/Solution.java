// 49189번 가장 먼 노드
package PG_49189;

import java.util.*;

class Solution {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisit;

    public int solution(int n, int[][] edge) {        
        isVisit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] vertex : edge) {
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }

        return bfs(1);
    }

    private int bfs(int x) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, 0));
        isVisit[x] = true;

        int max = Integer.MIN_VALUE;
        int cnt = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int parentNum = node.num;
            int parentCount = node.count;

            for (int i = 0; i < graph.get(parentNum).size(); i++) {
                int childNode = graph.get(parentNum).get(i);

                if (isVisit[childNode]) {
                    continue;
                }

                q.offer(new Node(childNode, parentCount + 1));
                isVisit[childNode] = true;

                if (max < (parentCount + 1)) {
                    max = parentCount + 1;
                    cnt = 1;
                } else if (max == (parentCount + 1)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

class Node {
    int num;
    int count;

    public Node (int num, int count) {
        this.num = num;
        this.count = count;
    }
}