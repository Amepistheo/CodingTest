// 10818번 최소, 최대
package BOJ_10818;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 입력 받은 정수 개수 (N)
        String input = br.readLine();               // 입력 받은 N개의 정수

        String[] inputArr = input.split(" ");   // input의 내용을 띄어쓰기를 기준으로 String 배열로 바꿈
        int min = Integer.parseInt(inputArr[0]);      // min 초기화
        int max = Integer.parseInt(inputArr[0]);      // max 초기화

        for (int i=0; i<inputArr.length; i++) {
            if (min > Integer.parseInt(inputArr[i])) {
                min = Integer.parseInt(inputArr[i]);
            }

            if (max < Integer.parseInt(inputArr[i])) {
                max = Integer.parseInt(inputArr[i]);
            }
        }

        System.out.println(min + " " + max);
    }
}
