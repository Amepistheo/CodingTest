// 1449번 수리공 항승
package BOJ_1449;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] water = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water);

        double left = water[0] - 0.5;
        int count = 1;

        for (int i = 0; i < N; i++) {
            if (left + L < water[i]) {
                count++;
                left = water[i] - 0.5;
            }
        }

        System.out.println(count);
    }
}