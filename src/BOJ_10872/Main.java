// 10872번 팩토리얼
package BOJ_10872;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = 1;

        if (N > 0) {
            for (int i = N; i > 0; i--) {
                result *= i;
            }
        }

        System.out.println(result);
    }
}