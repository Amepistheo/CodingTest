// 2869번 달팽이는 올라가고 싶다
package BOJ_2869;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V-B) / (A-B);

        if ((V-B) % (A-B) != 0)
            day++;

        System.out.println(day);
    }
}