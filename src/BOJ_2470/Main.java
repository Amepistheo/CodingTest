// 2470번 두 용액
package BOJ_2470;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Long[] solution = new Long[N];
        Long[] position = new Long[2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(solution);

        int left = 0;
        int right = N - 1;
        long min = Long.MAX_VALUE;

        position[0] = solution[left];
        position[1] = solution[right];

        while (left < right) {
            if (Math.abs(solution[left] + solution[right]) < Math.abs(min)) {
                min = Math.abs(solution[left] + solution[right]);

                position[0] = solution[left];
                position[1] = solution[right];
            }

            if (solution[left] + solution[right] <= 0) {
                left++;
            } else {
                right--;
            }
        }

        sb.append(position[0]).append(" ").append(position[1]);

        System.out.println(sb);
    }
}