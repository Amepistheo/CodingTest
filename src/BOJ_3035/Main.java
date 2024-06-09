// 3035번 스캐너
package BOJ_3035;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        char[][] map = new char[51][51];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < ZR; j++) {
                for (int k = 0; k < C; k++) {
                    for (int l = 0; l < ZC; l++) {
                        sb.append(map[i][k]);
                    }
                }

                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}