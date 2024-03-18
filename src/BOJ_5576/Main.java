// 5576번 콘테스트
package BOJ_5576;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] W = new int[10];
        int[] K = new int[10];

        for (int i = 0; i < 10; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            K[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(W);
        Arrays.sort(K);

        int sumW = W[7] + W[8] + W[9];
        int sumK = K[7] + K[8] + K[9];

        System.out.println(sumW + " " + sumK);
    }
}