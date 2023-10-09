// 11725번 트리의 부모 찾기
package BOJ_11725;

import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();

    static int[] parent;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        parent = new int[N+1];
        isVisit = new boolean[N+1];

        // graph에 값 넣기
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            graph.get(V1).add(V2);
            graph.get(V2).add(V1);
        }

        bfs();

        for (int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        isVisit[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i=0; i<graph.get(node).size(); i++) {
                int node2 = graph.get(node).get(i);

                if (isVisit[node2])
                    continue;

                q.offer(node2);
                parent[node2] = node;
                isVisit[node2] = true;
            }
        }
    }
}