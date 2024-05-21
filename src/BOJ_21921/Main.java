// 21921번 블로그
package BOJ_21921;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitor = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < X; i++) {
            sum += visitor[i];
        }

        int max = sum;
        int count = 1;

        for (int i = 1; i <= N - X; i++) {
            sum += - visitor[i-1] + visitor[i+X-1];

            if (max == sum) {
                count++;
            }
            else if (max < sum) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) {
            sb.append("SAD");
        }
        else {
            sb.append(max).append("\n").append(count);
        }

        System.out.println(sb);
    }
}