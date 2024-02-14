// 14467번 소가 길을 건너간 이유 1
package BOJ_14467;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] cow = new int[11];

        for (int i = 1; i <= 10; i++) {
            cow[i] = -1;
        }

        int count = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cowN = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (cow[cowN] == -1) {
                cow[cowN] = position;
            }
            else if (cow[cowN] != position) {
                cow[cowN] = position;
                count++;
            }
        }

        System.out.println(count);
    }
}