// 2576번 홀수
package BOJ_2576;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new PriorityQueue<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());

            if ((num % 2) != 0) {
                count++;
                sum += num;
                q.offer(num);
            }
        }

        if (count == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(q.poll());
        }

        System.out.println(sb);
    }
}