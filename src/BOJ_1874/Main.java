// 1874번 스택 수열
package BOJ_1874;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();                   // stack 선언

        int n = Integer.parseInt(br.readLine());                // 입력될 수열의 수 n
        int[] inputArr = new int[n];
        int highest = 0;                                        // 들어왔던 수 중 가장 큰 수
        boolean isPossible = true;                              // 불가능 여부 판단

        // inputArr 배열에 만들고자하는 수열 저장
        for (int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<n; i++) {
            if (highest < inputArr[i]){                         // highest보다 입력된 수가 더 큰 경우
                for (int j=highest+1; j<=inputArr[i]; j++) {    // highest+1부터 입력된 수까지 stack에 push함 & sb에 '+' 넣어줌
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                stack.pop();                                    // 입력된 수가 수열에 있기 때문에 stack에서 pop함 & sb에 '-' 넣어줌
                sb.append('-').append('\n');
                highest = inputArr[i];
            }
            // top > inputArr[i]인 경우
            else {
                int peekTop = stack.peek();                     // stack에 제일 위에 있는 수를 peekTop에 넣음

                if (peekTop == inputArr[i]) {                   // peekTop과 inputArr[i]의 값 비교하여 같으면 stack에서 pop함 & sb에 '-' 넣어줌
                    stack.pop();
                    sb.append('-').append('\n');
                }
                else                                            // peekTop의 값보다 inputArr[i]이 작은 경우 inputArr[i]의 값이 먼저 pop할 수 없기 때문에 불가능함!
                    isPossible = false;
            }
        }

        // isPossible = true인 경우 sb 출력 /  아닌 경우 "NO" 출력
        if (isPossible)
            System.out.print(sb);
        else
            System.out.println("NO");
    }
}