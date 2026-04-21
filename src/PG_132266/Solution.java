// 132266번 부대복귀
package PG_132266;

import java.util.*;

class Solution {

    private List<List<Integer>> graph = new ArrayList<>();

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] array = new int[n + 1];

        Arrays.fill(array, -1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        array[destination] = 0;

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int next : graph.get(poll)) {
                if (array[next] != -1) {
                    continue;
                }

                array[next] = array[poll] + 1;
                q.offer(next);
            }
        }

        int index = 0;

        for (int source : sources) {
            answer[index] = array[source];
            index++;
        }

        return answer;
    }
}