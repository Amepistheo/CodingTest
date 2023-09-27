// 1110번 더하기 사이클
package BOJ_1110;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int first = N;
        int count = 0;

        while (true) {
            int left = first / 10;
            int right = first % 10;

            first = (right)*10 + (left+right)%10;

            count++;

            if (first == N)
                break;
        }

        System.out.println(count);
    }
}