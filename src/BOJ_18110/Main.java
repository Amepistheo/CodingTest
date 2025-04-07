// 18110번 solved.ac
package BOJ_18110;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int exception = (int) Math.round(n * 0.15);

        int[] list = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i <= exception || (n - exception) < i) {
                continue;
            }

            sum += list[i];
        }

        int average = Math.round((float) sum / (n - (2 * exception)));

        System.out.println(average);
    }
}