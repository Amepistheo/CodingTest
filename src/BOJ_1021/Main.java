// 1021번 회전하는 큐
package BOJ_1021;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedList<Integer> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());           // 큐의 크기
        int M = Integer.parseInt(st.nextToken());           // 뽑아내려는 수의 개수

        int[] result = new int[M];                          // 뽑아내려는 수의 위치

        int count = 0;

        for (int i=1; i<=N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            result[i] = Integer.parseInt(st.nextToken());

            int target = deque.indexOf(result[i]);          // 뽑고자 하는 수의 위치(index)
            int mid;                                        // 중간 지점의 위치

            if (deque.size()%2 == 0)
                mid = deque.size()/2 - 1;
            else
                mid = deque.size()/2;

            if (target <= mid) {
                for (int j=0; j<target; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else {
                for (int j=0; j<deque.size()-target; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}