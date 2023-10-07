// 3052번 나머지
package BOJ_3052;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        boolean[] list = new boolean[42];

        for (int i=0; i<10; i++) {
            int N = Integer.parseInt(br.readLine());

            int rest = (N % 42);
            list[rest] = true;
        }

        for (int i=0; i<42; i++) {
            if (list[i])
                count++;
        }

        System.out.println(count);
    }
}