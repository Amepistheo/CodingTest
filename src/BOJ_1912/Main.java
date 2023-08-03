// 1912번 연속합
package BOJ_1912;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] inputArr = new int[n];            // 입력값 저장 배열
        int[] countArr = new int[n];            // 이전까지 값의 합과 현재 값을 비교하여 큰 값 저장하는 배열

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++)
            inputArr[i] = Integer.parseInt(st.nextToken());

        countArr[0] = inputArr[0];
        int answer = countArr[0];

        for (int i=1; i<n; i++) {
            // (이전 countArr + 현재 inputArr 값) 과 현재 inputArr 값을 비교하여 큰 값을 저장함
            countArr[i] = Math.max(countArr[i-1] + inputArr[i], inputArr[i]);
            // 최댓값 갱신
            answer = Math.max(answer, countArr[i]);
        }

        System.out.println(answer);
    }
}
