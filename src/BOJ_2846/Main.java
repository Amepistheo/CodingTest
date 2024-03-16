// 2846번 오르막길
package BOJ_2846;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] uphill = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            uphill[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int temp = 0;

        for (int i = 0; i < N - 1; i++) {
            if (uphill[i] < uphill[i + 1]) {
                temp += (uphill[i + 1] - uphill[i]);
            }
            else {
                temp = 0;
            }

            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}