// 2480번 주사위 세개
package BOJ_2480;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] dice = new int[7];

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st.nextToken());

            dice[x]++;

            if (max < dice[x]) {
                max = dice[x];
            }
        }
    }

    private static void solveProblem() {
        int pip = 0;

        for (int i = 1; i <= 6; i++) {
            if (dice[i] == 3) {
                System.out.println(10000 + i * 1000);
                return;
            } else if (dice[i] == 2) {
                System.out.println(1000 + i * 100);
                return;
            } else if (dice[i] == 1) {
                if (pip < i) {
                    pip = i;
                }
            }
        }

        System.out.println(pip * 100);
    }
}