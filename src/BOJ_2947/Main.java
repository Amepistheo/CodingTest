// 2947번 나무 조각
package BOJ_2947;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] piece = new int[5];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            piece[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            boolean check = false;

            for (int i = 0; i < 4; i++) {
                if (piece[i] > piece[i + 1]) {
                    int temp = piece[i];
                    piece[i]  = piece[i + 1];
                    piece[i + 1] = temp;

                    check = true;

                    for (int j = 0; j < 5; j++) {
                        sb.append(piece[j]).append(" ");
                    }

                    sb.append("\n");
                }
            }

            if (!check) {
                break;
            }
        }

        System.out.print(sb);
    }
}