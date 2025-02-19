// 1138번 한 줄로 서기
package BOJ_1138;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int j = 0;

            while (true) {
                if (line[i] == 0 && answer[j] == 0) {
                    answer[j] = i + 1;
                    break;
                } else if (answer[j] == 0) {
                    line[i]--;
                }

                j++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}