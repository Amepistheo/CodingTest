// 1005번 ACM Craft
package BOJ_1005;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<List<Integer>> building = new ArrayList<>();
            int[] time = new int[N + 1];
            int[] inDegree = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                building.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                building.get(X).add(Y);
                inDegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            sb.append(topologicalSort(N, time, building, inDegree, W)).append("\n");
        }

        System.out.print(sb);
    }

    private static int topologicalSort(int N, int[] time, List<List<Integer>> building, int[] inDegree, int target) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            result[i] = time[i];

            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : building.get(current)) {
                result[next] = Math.max(result[next], result[current] + time[next]);
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return result[target];
    }
}