// 3009번 네 번째 점
package BOJ_3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        if (x[1] == x[0]) {
            sb.append(x[2]).append(" ");
        }
        else if (x[1] == x[2]) {
            sb.append(x[0]).append(" ");
        }

        if (y[1] == y[0]) {
            sb.append(y[2]);
        }
        else if (y[1] == y[2]) {
            sb.append(y[0]);
        }

        System.out.println(sb);
    }
}