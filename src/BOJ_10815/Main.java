// 10815번 숫자 카드
package BOJ_10815;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        card = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (binarySearch(num))
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.print(sb);
    }

    static boolean binarySearch(int num) {
        int left = 0;
        int right = N-1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int mid = card[middle];

            if (num < mid)
                right = middle - 1;
            else if (num > mid)
                left = middle + 1;
            else
                return true;
        }

        return false;
    }
}