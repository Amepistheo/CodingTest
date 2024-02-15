// 5596번 시험 점수
package BOJ_5596;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int infoS = Integer.parseInt(st.nextToken());
        int mathS = Integer.parseInt(st.nextToken());
        int scienceS = Integer.parseInt(st.nextToken());
        int engS = Integer.parseInt(st.nextToken());

        int S = infoS + mathS + scienceS + engS;

        st = new StringTokenizer(br.readLine());

        int infoT = Integer.parseInt(st.nextToken());
        int mathT = Integer.parseInt(st.nextToken());
        int scienceT = Integer.parseInt(st.nextToken());
        int engT = Integer.parseInt(st.nextToken());

        int T = infoT + mathT + scienceT + engT;

        if (S > T) {
            System.out.println(S);
        }
        else {
            System.out.println(T);
        }
    }
}