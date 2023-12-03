// 1748번 수 이어 쓰기 1
package BOJ_1748;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int total = 0;
        int num = 1;
        int criteria = 10;

        for (int i=1; i<=N; i++) {
            if ((i % criteria) == 0) {
                num += 1;
                criteria *= 10;
            }

            total += num;
        }

        System.out.println(total);
    }
}