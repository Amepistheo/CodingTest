// 2563번 색종이
package BOJ_2563;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] square = new boolean[100][100];
        int count = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j=x; j<x+10; j++) {
                for (int k=y; k<y+10; k++) {
                    square[j][k] = true;
                }
            }
        }

        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (square[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}