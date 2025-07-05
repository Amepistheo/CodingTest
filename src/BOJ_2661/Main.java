// 2661번 좋은수열
package BOJ_2661;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static String result;
    private static boolean isFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dfs("");

        System.out.println(result);
    }

    private static void dfs(String sequence) {
        if (isFind) {
            return;
        }

        if (sequence.length() == N) {
            result = sequence;
            isFind = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (goodSequence(sequence + i)) {
                dfs(sequence + i);
            }
        }
    }

    private static boolean goodSequence(String nextSeq) {
        for (int i = 1; i <= nextSeq.length() / 2; i++) {
            String front = nextSeq.substring(nextSeq.length() - 2 * i, nextSeq.length() - i);
            String back = nextSeq.substring(nextSeq.length() - i);

            if (front.equals(back)) {
                return false;
            }
        }

        return true;
    }
}