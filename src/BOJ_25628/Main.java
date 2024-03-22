// 25628번 햄버거 만들기
package BOJ_25628;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;

        while (true)  {
            if (A <= 1 || B == 0) {
                break;
            }

            A -= 2;
            B -= 1;

            count++;
        }

        System.out.println(count);
    }
}