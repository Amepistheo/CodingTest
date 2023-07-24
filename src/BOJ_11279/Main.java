// 11279번 최대 힙
package BOJ_11279;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int N = Integer.parseInt(br.readLine());            // 연산의 개수

        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());        // 연산에 대한 정보

            if (x == 0) {
                if (q.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(q.poll()).append('\n');
            }
            else
                q.offer(x);
        }

        System.out.print(sb);
    }
}