// 1697번 숨바꼭질
package BOJ_1697;

import java.io.*;
import java.util.*;

public class Main {

    static int[] isVisit;

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisit = new int[100001];

        System.out.println(bfs(N));

    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        int n = 0;

        q.offer(start);
        isVisit[start] = 1;

        while(!q.isEmpty()) {
            n = q.poll();

            if (n == K)
                return isVisit[n]-1;
            if (n-1 >= 0 && isVisit[n-1] == 0) {
                q.offer(n-1);
                isVisit[n-1] = isVisit[n] + 1;
            }
            if (n+1 <= 100000 && isVisit[n+1] == 0) {
                q.offer(n+1);
                isVisit[n+1] = isVisit[n] + 1;
            }
            if (2*n <= 100000 && isVisit[2*n] == 0) {
                q.offer(2*n);
                isVisit[2*n] = isVisit[n] + 1;
            }
        }

        return -1;
    }
}