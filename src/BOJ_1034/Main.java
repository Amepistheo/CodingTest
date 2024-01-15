// 1034번 램프
package BOJ_1034;

import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, K;
    private static int max;

    private static int[][] lamp;
    private static String[] s;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lamp = new int[N][M];
        s = new String[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();

            for (int j = 0; j < M; j++) {
                lamp[i][j] = Integer.parseInt(String.valueOf(s[i].charAt(j)));
            }
        }

        K = Integer.parseInt(br.readLine());

        lampCheck();
        lampMax();

        System.out.println(max);
    }

    private static void lampCheck() {
        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = 0; j < M; j++) {
                if (lamp[i][j] == 0) {
                    count++;
                }
            }

            if (((count % 2) == (K % 2)) && (count <= K)) {
                check[i] = true;
            }
        }
    }

    private static void lampMax() {
        max = 0;

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < N; j++) {
                if (s[i].equals(s[j])) {
                    count++;
                }
            }

            if (max < count) {
                max = count;
            }
        }
    }
}