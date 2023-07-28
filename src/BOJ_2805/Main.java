// 2805번 나무 자르기
package BOJ_2805;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());           // 나무의 수
        int M = Integer.parseInt(st.nextToken());           // 나무의 길이


        Integer[] inputArr = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        // 나무의 길이 내림차순 정렬
        Arrays.sort(inputArr, Collections.reverseOrder());

        long low = 0;
        long high = inputArr[0];

        // 높이의 최댓값 이분탐색을 통해 알아냄
        // Upper Bound : 중복이 존재하거나 없는 데이터를 탐색할 경우, 바로 다음 결과값 반환 (가장 오른쪽 위치 구함)
        // Lower Bound : 중복이 존재하거나 없는 데이터를 탐색할 경우, 일치하는 숫자가 가장 처음 나타나는 값을 반환 (가장 왼쪽 위치 구함)
        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int j=0; j<N; j++) {
                if (inputArr[j] - mid > 0)
                    count += (inputArr[j] - mid);
            }

            // count > M 의 경우로 바꾸게 되면 low를 print 해야함 (가장 마지막으로 변한 값이 low이기 때문)
            if (count < M)
                high = mid-1;
            else
                low = mid+1;
        }

        System.out.println(high);
    }
}