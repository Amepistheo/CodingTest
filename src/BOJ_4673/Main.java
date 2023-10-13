// 4673번 셀프 넘버
package BOJ_4673;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001];

        for (int i=0; i<=10000; i++) {
            int num = i;
            int sum = num;

            while (num != 0) {
                sum += (num%10);
                num /= 10;
            }

            if (sum < 10001)
                check[sum] = true;
        }

        for (int i=1; i<=10000; i++) {
            if (!check[i])
                sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}