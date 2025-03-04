// 9934번 완전 이진 트리
package BOJ_9934;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] tree;
    private static String[] answer;

    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        tree = new int[(int) (Math.pow(2, K) - 1)];
        answer = new String[K];

        String[] str = br.readLine().split(" ");

        int index = 0;

        for (String s : str) {
            tree[index] = Integer.parseInt(s);
            index++;
        }

        for (int i = 0; i < K; i++) {
            answer[i] = "";
        }

        search(0, str.length, 0);

        for (int i = 0; i < K; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void search(int left, int right, int depth) {
        if (depth == K) {
            return;
        }

        int mid = (left + right) / 2;
        answer[depth] += (tree[mid] + " ");

        search(left, mid - 1, depth + 1);
        search(mid + 1, right, depth + 1);
    }
}