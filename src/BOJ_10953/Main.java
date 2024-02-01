// 10953번 A+B - 6
package BOJ_10953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(",");

            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            sb.append(A + B).append("\n");
        }

        System.out.print(sb);
    }
}