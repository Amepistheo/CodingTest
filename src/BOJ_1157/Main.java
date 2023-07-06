// 1157번 단어 공부
package BOJ_1157;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] countArr = new int[26];       // 입력된 문자열이 어떤 알파벳인지, 몇 개인지 저장

        int max = 0;                        // 가장 많이 사용된 알파벳의 개수
        int count = 0;                      // max의 값이 여러개인 경우 확인
        char alphabet = 'A';

        // 입력된 문자열과 알파벳 비교하여 배열에 저장 (각각의 알파벳의 위치에)
        for (int i=0; i<input.length(); i++) {
            for (int j=0; j<26; j++) {
                if (input.charAt(i) == (char)('a'+j) || input.charAt(i) == (char)('A'+j))
                    countArr[j]++;
            }
        }

        // 가장 많이 사용한 알파벳의 개수 알아내기 (max)
        for (int i=0; i<26; i++) {
            if (max < countArr[i])
                max = countArr[i];
        }

        // max의 값과 countArr 배열의 수를 비교하여 max의 값이 여러개라면 count를 통해 알아냄
        // 가장 많이 사용한 알파벳을 알아낸 경우 alphabet에 저장
        for (int i=0; i<26; i++) {
            if (max == countArr[i]) {
                count++;                // max의 값이 중복되었는지 count
                alphabet += i;
            }
        }

        // count의 개수를 통해 알아낸 max의 값이 여러개인 경우 ? 출력 / max의 값이 1개라면 alphabet에 저장된 알파벳 출력
        if (count > 1)
            System.out.println('?');
        else
            System.out.println(alphabet);
    }
}
