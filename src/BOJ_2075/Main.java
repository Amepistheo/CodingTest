// 2075번 N번째 큰 수
package BOJ_2075;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Long> q = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                q.offer(Long.parseLong(st.nextToken()));
            }
        }

        int count = N;

        while (count > 1) {
            q.poll();
            count--;
        }

        System.out.println(q.poll());
    }
}