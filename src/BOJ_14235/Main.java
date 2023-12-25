// 14235번 크리스마스 선물
package BOJ_14235;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(q.poll()).append("\n");
                }
            }
            else {
                for (int j = 0; j < a; j++) {
                    q.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.print(sb);
    }
}