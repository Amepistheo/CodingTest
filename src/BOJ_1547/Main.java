// 1547번 공
package BOJ_1547;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        int num = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int X =Integer.parseInt(st.nextToken());
            int Y =Integer.parseInt(st.nextToken());

            if (X == num) {
                num = Y;
            }
            else if (Y == num){
                num = X;
            }
        }

        System.out.println(num);
    }
}