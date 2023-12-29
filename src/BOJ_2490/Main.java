// 2490번 윷놀이
package BOJ_2490;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int[] game = new int[2];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                game[Integer.parseInt(st.nextToken())]++;
            }

            if (game[0] == 1) {
                sb.append("A").append("\n");
            }
            else if (game[0] == 2) {
                sb.append("B").append("\n");
            }
            else if (game[0] == 3) {
                sb.append("C").append("\n");
            }
            else if (game[0] == 4) {
                sb.append("D").append("\n");
            }
            else if (game[0] == 0) {
                sb.append("E").append("\n");
            }
        }

        System.out.print(sb);
    }
}