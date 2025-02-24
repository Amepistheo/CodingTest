// 3020번 개똥벌레
package BOJ_3020;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[H + 2];
        int[] up = new int[H + 2];

        for (int i = 1; i <= N / 2; i++) {
            int d = Integer.parseInt(br.readLine());
            int u = H - Integer.parseInt(br.readLine()) + 1;

            down[d]++;
            up[u]++;
        }

        for (int i = 1; i <= H; i++) {
            down[i] += down[i - 1];
        }

        for (int i = H; i >= 0; i--) {
            up[i] += up[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 1; i <= H; i++) {
            int count = (down[H] - down[i - 1]) + (up[0] - up[i + 1]);

            if (count < min) {
                min = count;
                total = 1;
            } else if (count == min) {
                total++;
            }
        }

        System.out.println(min + " " + total);
    }
}