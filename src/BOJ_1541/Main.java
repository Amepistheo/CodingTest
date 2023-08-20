// 1541번 잃어버린 괄호
package BOJ_1541;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;

        // 우선 -를 기준으로 token을 나눔
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()) {
            int temp = 0;

            // -로 나눈 토큰 내에 +를 기준으로 다시 토큰 나눔
            StringTokenizer str = new StringTokenizer(st.nextToken(), "+");

            while(str.hasMoreTokens()) {
                temp += Integer.parseInt(str.nextToken());
            }

            if (sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }

        System.out.println(sum);
    }
}
