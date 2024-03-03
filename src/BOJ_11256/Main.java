// 11256번 사탕
package BOJ_11256;

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

            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            Integer[] box = new Integer[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                box[j] = R * C;
            }

            Arrays.sort(box, Collections.reverseOrder());

            int count = 0;

            for (int j = 0; j < N; j++) {
                if (J <= 0) {
                    break;
                }
                else {
                    J -= box[j];
                    count++;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}