// 15903번 카드 합체 놀이
package BOJ_15903;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        Queue<Long> q = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            q.offer(Long.parseLong(st.nextToken()));
        }

        while (m > 0) {
            long a1 = q.poll();
            long a2 = q.poll();

            a1 = a2 = (a1 + a2);

            q.offer(a1);
            q.offer(a2);

            m--;
        }

        long size = q.size();
        long sum = 0;

        for (int i = 0; i < size; i++) {
            sum += q.poll();
        }

        System.out.println(sum);
    }
}