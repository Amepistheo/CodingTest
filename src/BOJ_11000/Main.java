// 11000번 강의실 배정
package BOJ_11000;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] lesson = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            lesson[i][0] = Integer.parseInt(st.nextToken());
            lesson[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lesson, ((o1, o2) -> {return o1[0] - o2[0];}));

        Queue<Integer> q = new PriorityQueue<>();
        q.offer(lesson[0][1]);

        for (int i = 1; i < N; i++) {
            if (lesson[i][0] >= q.peek()) {
                q.poll();
            }

            q.offer(lesson[i][1]);
        }

        System.out.println(q.size());
    }
}