// 9095번 1, 2, 3 더하기
package BOJ_9095;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());            // 테스트 케이스의 개수

        int[] count = new int[11];                          // n은 양수이며 11보다 작은 수

        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());        // 입력받은 정수

            if (n >= 4) {
                for (int j=4; j<=n; j++) {
                    count[j] = (count[j-3] + count[j-2] + count[j-1]);
                }
            }

            sb.append(count[n]).append('\n');
        }

        System.out.print(sb);
    }
}
