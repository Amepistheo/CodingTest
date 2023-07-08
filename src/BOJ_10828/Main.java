// 10828번 스택
package BOJ_10828;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();       // Stack 선언

        int N = Integer.parseInt(br.readLine());    // 명령의 수 N
        String[] input = new String[N];             // 입력받은 명령을 input 배열에 저장
        String pushString;                          // push 입력일 경우 pushString 문자열에 저장
        String[] pushInt;                           // pushString에서 띄어쓰기를 기준으로 pushInt 배열에 저장

        // 입력받은 명령을 input 배열에 저장
        for (int i=0; i<N; i++) {
            input[i] = br.readLine();
        }

        // 입력받은 명령에 따라 반복문을 통해 처리함
        for (int i=0; i<N; i++) {
            if (input[i].length() > 5) {                    // 입력이 push 인 경우 길이가 5이상임
                pushString = input[i];                      // pushString에 문자열 저장
                pushInt = pushString.split(" ");      // 띄어쓰기를 기준으로 pushInt 배열에 저장
                stack.push(Integer.valueOf(pushInt[1]));    // 입력된 정수값을 stack에 push함
            }
            else if (input[i].equals("top")) {              // top 명령인 경우 peek() 함수 사용 / stack 비어있으면 -1 출력
                if (stack.empty())
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
            }
            else if (input[i].equals("pop")) {              // pop 명령인 경우 pop() 함수 사용 / stack 비어있으면 -1 출력
                if (stack.empty())
                    System.out.println(-1);
                else
                    System.out.println(stack.pop());
            }
            else if (input[i].equals("empty")) {            // empty stack 비어있으면 1 출력 아니면 0 출력
                if (stack.empty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if (input[i].equals("size"))               // size 명령인 경우 size() 함수 사용
                System.out.println(stack.size());
        }
    }
}