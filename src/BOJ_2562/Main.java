// 2562번 최댓값
package BOJ_2562;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = new int[9];
        int max = Integer.MIN_VALUE;

        for (int i=0; i<9; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputArr[i]);
        }
        System.out.println(max);

        for (int i=0; i<9; i++) {
            if (max == inputArr[i])
                System.out.println(i+1);
        }
    }
}