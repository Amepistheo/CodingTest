// 1003번 피보나치 함수
package BOJ_1003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] fibonacci = new int[41];

        fibonacci[1] = 1;

        for (int i=2; i<=40; i++)
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

        for (int i=0; i<T; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                sb.append("1 0").append("\n");
                continue;
            }

            sb.append(fibonacci[input-1] + " " + fibonacci[input]).append("\n");
        }

        System.out.print(sb);
    }
}
