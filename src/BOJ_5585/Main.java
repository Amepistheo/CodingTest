// 5585번 거스름돈
package BOJ_5585;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1000 - Integer.parseInt(br.readLine());

        int[] coin = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int i=0; i<6; i++) {
            if ((N / coin[i]) > 0) {
                count += (N / coin[i]);
                N %= coin[i];
            }
        }

        System.out.println(count);
    }
}