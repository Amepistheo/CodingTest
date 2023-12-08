// 2506번 점수계산
package BOJ_2506;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int result = 0;
        int check = 0;

        for (int i=0; i<N; i++) {
            int score = Integer.parseInt(st.nextToken());

            if (score == 1) {
                check++;
            }
            else {
                check = 0;
            }

            result += check;
        }

        System.out.println(result);
    }
}