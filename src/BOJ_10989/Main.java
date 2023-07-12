// 10989번 수 정렬하기3
package BOJ_10989;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] sortArr = new int[N];

        // 한 줄씩 입력받은 값을 ArrayList l에 저장
        for (int i=0; i<N; i++) {
            sortArr[i] = Integer.parseInt(br.readLine());
        }

        // sortArr 오름차순 정렬
        Arrays.sort(sortArr);

        // 값 하나씩 sb에 저장
        for(int v : sortArr)
            sb.append(v).append("\n");

        System.out.print(sb);
    }
}