// 1946번 신입 사원
package BOJ_1946;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] employee = new int[N][2];

            for (int j = 0; j < N ; j++) {
                st = new StringTokenizer(br.readLine());

                employee[j][0] = Integer.parseInt(st.nextToken());
                employee[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(employee, (o1, o2) -> o1[0] - o2[0]);

            int interview = employee[0][1];
            int count = 1;

            for (int j = 1; j < N; j++) {
                if (employee[j][1] < interview) {
                    interview = employee[j][1];
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}