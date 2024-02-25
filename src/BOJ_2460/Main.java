// 2460번 지능형 기차 2
package BOJ_2460;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] train = new int[11];

        train[0] = 0;

        for (int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());

            train[i] = train[i - 1] - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        }

        Arrays.sort(train);

        System.out.println(train[10]);
    }
}