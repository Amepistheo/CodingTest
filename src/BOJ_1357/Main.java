// 1357번 뒤집힌 덧셈
package BOJ_1357;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();

        String reverseX = "";
        String reverseY = "";

        for (int i = X.length() - 1; i >= 0; i--) {
            reverseX += X.charAt(i);
        }

        for (int i = Y.length() - 1; i >= 0; i--) {
            reverseY += Y.charAt(i);
        }

        String sum = String.valueOf(Integer.parseInt(reverseX) + Integer.parseInt(reverseY));

        String reverseSum = "";

        for (int i = sum.length() - 1; i >= 0; i--) {
            reverseSum += sum.charAt(i);
        }

        System.out.println(Integer.parseInt(reverseSum));
    }
}