// 1120번 문자열
package BOJ_1120;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int result = 50;

        for (int i=0; i<=(B.length() - A.length()); i++) {
            int count = 0;

            for (int j=0; j<A.length(); j++) {
                if (A.charAt(j) != B.charAt(j+i)) {
                    count++;
                }
            }

            result = Math.min(result, count);
        }

        System.out.println(result);
    }
}