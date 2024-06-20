// 21318번 피아노 체조
package BOJ_21318;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] music = new int[N+1];
        int[] mistake = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            if (music[i] > music[i+1]) {
                mistake[i] = mistake[i-1] + 1;
            }
            else {
                mistake[i] = mistake[i-1];
            }
        }

        mistake[N] = mistake[N-1];

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(mistake[y-1] - mistake[x-1]).append("\n");
        }

        System.out.print(sb);
    }
}