// 2588번 곱셈
package BOJ_2588;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int hundred = (B / 100);
        int ten = ((B % 100) / 10);
        int one = ((B % 100) % 10);

        sb.append(A * one).append("\n");
        sb.append(A * ten).append("\n");
        sb.append(A * hundred).append("\n");
        sb.append(A * B);

        System.out.print(sb);
    }
}
