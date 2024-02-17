// 2920번 음계
package BOJ_2920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] music = new int[9];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 8; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        String result = "";

        for (int i = 1; i < 8; i++) {
            if (music[i] == music[i + 1] - 1) {
                result = "ascending";
            }
            else if (music[i] == music[i + 1] + 1) {
                result = "descending";
            }
            else {
                result = "mixed";
                break;
            }
        }

        System.out.println(result);
    }
}