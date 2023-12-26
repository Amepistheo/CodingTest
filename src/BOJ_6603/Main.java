// 6603번 로또
package BOJ_6603;

import java.io.*;
import java.util.*;

public class Main {

    static int k;

    static int[] set;
    static boolean[] isVisit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            set = new int[k];
            isVisit = new boolean[k];

            if (k == 0) {
                break;
            }
            else {
                for (int i = 0; i < k; i++) {
                    set[i] = Integer.parseInt(st.nextToken());
                }
            }

            backtracking(0, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void backtracking(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (isVisit[i]) {
                    sb.append(set[i]).append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = start; i < k; i++) {
            isVisit[i] = true;
            backtracking(depth + 1, i + 1);
            isVisit[i] = false;
        }
    }
}