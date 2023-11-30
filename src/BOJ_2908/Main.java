// 2908번 상수
package BOJ_2908;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        StringBuilder asb = new StringBuilder(A);
        A = asb.reverse().toString();

        StringBuilder bsb = new StringBuilder(B);
        B = bsb.reverse().toString();

        int max = Math.max(Integer.parseInt(A), Integer.parseInt(B));

        System.out.println(max);
    }
}