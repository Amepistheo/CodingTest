// 6996번 애너그램
package BOJ_6996;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            String[] Arr = A.split("");
            String[] Brr = B.split("");

            Arrays.sort(Arr);
            Arrays.sort(Brr);

            if (Arrays.toString(Arr).equals(Arrays.toString(Brr))) {
                sb.append(A).append(" & ").append(B).append(" are anagrams.");
            }
            else {
                sb.append(A).append(" & ").append(B).append(" are NOT anagrams.");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}