// 10813번 공 바꾸기
package BOJ_10813;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ball = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            ball[i] = i;
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int temp = ball[i];
            ball[i] = ball[j];
            ball[j] = temp;
        }

        for (int i = 1; i < N+1; i++) {
            sb.append(ball[i]).append(" ");
        }

        System.out.println(sb);
    }
}