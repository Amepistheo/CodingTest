// 1149번 RGB거리
package BOJ_1149;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] home = new int[N+1][3];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i=2; i<=N; i++) {
            home[i][0] += Math.min(home[i-1][1], home[i-1][2]);
            home[i][1] += Math.min(home[i-1][0], home[i-1][2]);
            home[i][2] += Math.min(home[i-1][0], home[i-1][1]);
        }

        System.out.println(Math.min(home[N][0], Math.min(home[N][1], home[N][2])));
    }
}