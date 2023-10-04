// 2161번 카드1
package BOJ_2161;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            sb.append(q.poll()).append(" ");
            q.offer(q.poll());
        }

        sb.append(q.poll());

        System.out.println(sb);
    }
}