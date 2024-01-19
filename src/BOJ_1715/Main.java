// 1715번 카드 정렬하기
package BOJ_1715;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        int sum = 0;

        while (pq.size() > 1) {
            int A = pq.poll();
            int B = pq.poll();

            sum = (A + B);
            total += sum;

            pq.offer(sum);
        }

        System.out.println(total);
    }
}