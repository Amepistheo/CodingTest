// 14916번 거스름돈
package BOJ_14916;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (true) {
            if ((n % 5) == 0) {
                count += (n / 5);
                System.out.println(count);
                break;
            }
            else {
                n -= 2;
                count++;
            }

            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}