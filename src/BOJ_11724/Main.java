// 11724번 연결 요소의 개수
package BOJ_11724;

import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisit;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());                   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());               // 간선의 개수

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        isVisit = new boolean[N+1];

        // graph에 입력값 넣기
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            graph.get(V1).add(V2);
            graph.get(V2).add(V1);
        }

        System.out.println(search());
    }

    // 연결 요소의 개수 찾기
    public static int search() {
        int count = 0;

        for (int i=1; i<=N; i++) {
            if (isVisit[i])
                continue;

            bfs(i);
            count++;
        }

        return count;
    }

    // 연결 요소의 주변 탐색
    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        isVisit[x] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            for (int i=0; i<graph.get(node).size(); i++) {
                int node2 = graph.get(node).get(i);

                if (isVisit[node2])
                    continue;

                q.offer(node2);
                isVisit[node2] = true;
            }
        }
    }
}