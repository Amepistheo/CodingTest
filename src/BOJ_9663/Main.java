// 9663번 N-Queen
package BOJ_9663;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] chess;

    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        chess = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            chess[depth] = i;
            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (chess[col] == chess[i]) {
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(chess[col] - chess[i])) {
                return false;
            }
        }

        return true;
    }
}