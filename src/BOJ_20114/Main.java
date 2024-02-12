// 20114번 미아 노트
package BOJ_20114;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[] origin = new char[N];

        for (int i = 0; i < N; i++) {
            origin[i] = '?';
        }

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < N * W; j++) {
                if (s.charAt(j) == '?') {
                    continue;
                }
                else {
                    origin[j / W] = s.charAt(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(origin[i]);
        }

        System.out.println(sb);
    }
}