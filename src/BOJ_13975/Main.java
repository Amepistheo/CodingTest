// 13975번 파일 합치기 3
package BOJ_13975;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            Queue<Long> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            long total = 0;

            while (true) {
                long num1 = pq.poll();
                long num2 = pq.poll();

                sum = (num1 + num2);

                total += sum;

                if (pq.isEmpty()) {
                    break;
                }

                pq.offer(sum);
            }

            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}