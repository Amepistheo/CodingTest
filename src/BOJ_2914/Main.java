// 2914번 저작권
package BOJ_2914;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        System.out.println((A * (I-1)) + 1);
    }
}