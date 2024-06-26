// 2587번 대표값2
package BOJ_2587;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] num = new int[5];

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        Arrays.sort(num);

        sb.append(sum / 5).append("\n").append(num[2]);

        System.out.println(sb);
    }
}