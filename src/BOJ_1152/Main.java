// 1152번 단어의 개수
package BOJ_1152;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputArr = input.split(" ");           // 공백을 기준으로 input 문자열의 값을 inputArr 배열에 넣음

        if (inputArr.length != 0 && inputArr[0].equals(""))   // inputArr의 길이가 0이 아니면서 맨 처음에 공백이 있는 경우 length의 길이를 1 빼줌(맨 앞에 공백이 있는 경우 길이가 1 커짐)
            System.out.println(inputArr.length-1);            // inputArr의 길이가 0이 아닐 때가 중요!! (이거 땜에 런타임에러 남..)
        else                                                  // 아닌 경우 inputArr의 길이 그대로 출력
            System.out.println(inputArr.length);
    }
}
