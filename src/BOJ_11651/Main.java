// 11651번 좌표 정렬하기 2
package BOJ_11651;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] inputArr = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            inputArr[i][0] = Integer.parseInt(st.nextToken());
            inputArr[i][1] = Integer.parseInt(st.nextToken());
        }

        // y좌표 오름차순 정렬 (만약 y좌표가 같으면 x좌표 오름차순 정렬)
        Arrays.sort(inputArr, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];

            return o1[1] - o2[1];
        });

        for (int i=0; i<N; i++) {
            System.out.println(inputArr[i][0] + " " + inputArr[i][1]);
        }
    }
}
