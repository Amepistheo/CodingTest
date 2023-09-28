// 2193번 이친수
package BOJ_2193;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 꼭 long 타입으로 해야함! (int하면 틀림)
        long[][] binary = new long[91][2];

        binary[1][0] = 0;
        binary[1][1] = 1;

        for (int i=2; i<=N; i++) {
            binary[i][0] = binary[i-1][0] + binary[i-1][1];
            binary[i][1] = binary[i-1][0];
        }

        System.out.println(binary[N][0] + binary[N][1]);
    }
}