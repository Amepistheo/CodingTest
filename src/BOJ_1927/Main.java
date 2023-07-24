// 1927번 최소 힙
package BOJ_1927;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> pq = new PriorityQueue<>();          // 우선순위 큐 선언 (최소값 기준으로 정렬)

        int N = Integer.parseInt(br.readLine());            // 연산의 개수

        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());        // 연산에 대한 정보

            if (x == 0)                                     // 입력값이 0일 때 큐가 비어있으면 0 출력, 아니면 맨 앞의 수 출력 및 제거
                if (pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');

            else                                            // 0이 아닌 자연수 입력시 큐에 추가
                pq.offer(x);
        }

        System.out.println(sb);
    }
}
