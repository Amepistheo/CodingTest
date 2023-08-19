// 11727번 2*n 타일링 2
package BOJ_11727;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[1001];

        input[0] = 0;
        input[1] = 1;
        input[2] = 3;

        if(n >= 3) {
            for (int i=3; i<=n; i++) {
                input[i] = (input[i-1] + input[i-2]*2) % 10007;
            }
        }

        System.out.println(input[n]);
    }
}
