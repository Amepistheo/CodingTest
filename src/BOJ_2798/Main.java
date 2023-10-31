// 2798번 블랙잭
package BOJ_2798;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];
        int sum = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                for (int k=j+1; k<N; k++) {
                    sum = card[i] + card[j] + card[k];

                    if (max < sum && sum <= M)
                        max = sum;
                }
            }
        }

        System.out.println(max);
    }
}