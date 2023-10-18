// 25304번 영수증
package BOJ_25304;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int total = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            total += (a * b);
        }

        if (X == total)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}