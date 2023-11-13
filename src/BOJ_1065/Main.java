// 1065번 한수
package BOJ_1065;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1000) {
            System.out.println(144);
        }
        else if (N < 100) {
            System.out.println(N);
        }
        else {
            int count = 99;

            for (int i=100; i<=N; i++) {
                int first = i / 100;
                int second = (i / 10) % 10;
                int third = (i % 100) % 10;

                if ((first - second) == (second - third)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}