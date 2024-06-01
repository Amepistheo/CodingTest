// 14425번 문자열 집합
package BOJ_14425;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];

        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            String test = br.readLine();

            for (int j = 0; j < N; j++) {
                if (test.equals(S[j])) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}