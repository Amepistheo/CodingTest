// 14729번 칠무해
package BOJ_14729;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        double[] list = new double[N];

        for (int i = 0; i < N; i++) {
            list[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(list);

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", list[i])).append("\n");
        }

        System.out.print(sb);
    }
}