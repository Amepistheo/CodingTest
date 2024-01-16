// 1934번 최소공배수
package BOJ_1934;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int D = gcd(A, B);

            sb.append((A * B) / D).append("\n");
        }

        System.out.print(sb);
    }

    private static int gcd(int A, int B) {
        while (B != 0) {
            int R = (A % B);

            A = B;
            B = R;
        }

        return A;
    }
}