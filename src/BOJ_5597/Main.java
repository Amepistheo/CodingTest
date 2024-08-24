// 5597번 과제 안 내신 분..?
package BOJ_5597;

import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] task = new boolean[31];

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 28; i++) {
            task[Integer.parseInt(br.readLine())] = true;
        }
    }

    private static void solveProblem() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 30; i++) {
            if (!task[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}