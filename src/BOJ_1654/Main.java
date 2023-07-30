// 1654번 랜선 자르기
package BOJ_1654;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());               // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());               // 필요한 랜선의 개수

        Integer[] inputArr = new Integer[K];

        for (int i=0; i<K; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputArr, Collections.reverseOrder());      // 배열 내림차순 정렬

        // 랜선의 길이가 자연수이기 때문에 low를 1로 설정해줘야함
        long low = 1;
        long high = inputArr[0];

        while (low <= high) {
            long count = 0;
            long mid = (low + high) / 2;

            for (int i=0; i<K; i++)
                count += (inputArr[i] / mid);

            if (count < N)
                high = mid - 1;
            else
                low = mid + 1;
        }

        System.out.println(high);
    }
}