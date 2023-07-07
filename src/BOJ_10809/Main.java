// 10809번 알파벳 찾기
package BOJ_10809;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int[] countArr = new int[26];       // 각 알파벳이 처음 등장하는 위치 저장하는 배열

        // countArr 배열의 값들 -1로 초기화
        for (int i=0; i<26; i++) {
            countArr[i] = -1;
        }

        // 단어 S의 각 알파벳이 처음 등장하는 위치 찾아서 countArr 배열의 값 바꿔줌
        // 이때 알파벳이 처음 등장하는 위치이기 때문에 countArr[]의 값이 -1인 경우도 조건에 포함해야함!!
        for (int i=0; i<S.length(); i++) {
            for (int j=0; j<26; j++) {
                if ((S.charAt(i) == 'a'+j) && (countArr[j] == -1))
                    countArr[j] = i;
            }

        }

        for (int i=0; i<26; i++) {
            System.out.print(countArr[i] + " ");
        }

        System.out.println();
    }
}
