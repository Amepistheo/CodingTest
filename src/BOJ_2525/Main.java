// 2525번 오븐 시계
package BOJ_2525;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        int min = 60*A + B;
        min += C;

        int hour = (min/60) % 24;
        int minute = min % 60;

        System.out.println(hour + " " + minute);
    }
}