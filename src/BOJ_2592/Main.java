// 2592번 대표값
package BOJ_2592;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] number = new int[100];

        int max = Integer.MIN_VALUE;
        int average = 0;
        int pos = 0;

        for (int i=0; i<10; i++) {
            int n = Integer.parseInt(br.readLine());

            average += n;
            number[n/10]++;
        }

        for (int i=0; i<100; i++) {
            if (max < number[i]) {
                max = number[i];
                pos = i;
            }
        }

        System.out.println(average / 10);
        System.out.println(pos * 10);
    }
}