// 3711번 학번
package BOJ_3711;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int G = Integer.parseInt(br.readLine());

            int[] number = new int[G];

            for (int i = 0; i < G; i++) {
                number[i] = Integer.parseInt(br.readLine());
            }

            int m = 1;
            int[] list = new int[1000000];

            while (true) {
                boolean check = true;

                for (int i = 0; i < G; i++) {
                    int remain = number[i] % m;

                    if (list[remain] == m) {
                        check = false;
                        break;
                    }

                    list[remain] = m;
                }

                if (check) {
                    sb.append(m).append("\n");
                    break;
                }

                m++;
            }
        }

        System.out.print(sb);
    }
}