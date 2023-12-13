// 10824번 네 수
package BOJ_10824;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        String D = st.nextToken();

        long left = Long.parseLong(A + B);
        long right = Long.parseLong(C + D);

        System.out.println(left + right);
    }
}