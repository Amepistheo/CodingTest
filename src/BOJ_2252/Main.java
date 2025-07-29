// 2252번 줄 세우기
package BOJ_2252;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> list = new ArrayList<>();
    private static int[] count;
    private static int N;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            count[B]++;
        }

        topologicalSort();

        System.out.println(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.offer(i);
            }
        }

        for (int i = 0; i < N; i++) {
            if (!q.isEmpty()) {
                int poll = q.poll();
                sb.append(poll).append(" ");

                for (int j = 0; j < list.get(poll).size(); j++) {
                    count[list.get(poll).get(j)]--;

                    if (count[list.get(poll).get(j)] == 0) {
                        q.offer(list.get(poll).get(j));
                    }
                }
            }
        }
    }
}