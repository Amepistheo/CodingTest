// 19939번 박 터뜨리기
package BOJ_19939;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = -1;

        N -= (K * (K + 1)) / 2;

        if (N >= 0) {
            if (N % K == 0) {
                answer = K - 1;
            } else {
                answer = K;
            }
        }

        System.out.println(answer);
    }
}