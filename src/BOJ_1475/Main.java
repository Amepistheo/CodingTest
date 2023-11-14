// 1475번 방 번호
package BOJ_1475;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] number = new int[9];
        int max = Integer.MIN_VALUE;

        for (int i=0; i<N.length(); i++) {
            if (N.charAt(i) == '9') {
                number[6]++;
            }
            else {
                number[N.charAt(i) - '0']++;
            }
        }

        number[6] = (number[6] / 2) + (number[6] % 2);

        for (int i=0; i<9; i++) {
            max = Math.max(max, number[i]);
        }

        System.out.println(max);
    }
}