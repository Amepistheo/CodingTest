// 11286번 절댓값 힙
package BOJ_11286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 절댓값이 같은 경우 작은 수 부터 출력
                if (Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;

                // 절댓값 순으로 정렬
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0)
                q.offer(input);
            else {
                if (q.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(q.poll()).append("\n");
            }
        }

        System.out.print(sb);
    }
}