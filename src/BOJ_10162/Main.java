// 10162번 전자레인지
package BOJ_10162;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        if (T%10 != 0)
            sb.append(-1);
        else {
            int A = T / 300;
            T %= 300;

            int B = T / 60;
            T %= 60;

            sb.append(A).append(" ").append(B).append(" ").append(T/10);
        }

        System.out.print(sb);
    }
}