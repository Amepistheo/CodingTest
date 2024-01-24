// 10797번 10부제
package BOJ_10797;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] car = new int[5];

        st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < 5; i++) {
            car[i] = Integer.parseInt(st.nextToken());

            if (N == car[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}