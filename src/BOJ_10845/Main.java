// 10845번 큐
package BOJ_10845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();                  // Queue 선언

        int N = Integer.parseInt(br.readLine());                    // 명령의 수 N
        String[] inputArr = new String[N];                          // 입력받은 명령을 input 배열에 저장
        String pushString;                                          // push 입력일 경우 pushString 문자열에 저장
        String[] pushInt;                                           // pushString에서 띄어쓰기를 기준으로 pushInt 배열에 저장
        int last = 0;                                               // 큐의 가장 뒤에 있는 정수 저장

        // inputArr 배열에 명령 저장
        for (int i=0; i<N; i++) {
            inputArr[i] = br.readLine();
        }

        for (int i=0; i<N; i++) {
            if (inputArr[i].length()>5) {                           // 입력값이 push인 경우
                pushString = inputArr[i];
                pushInt = pushString.split(" ");
                queue.add(Integer.parseInt(pushInt[1]));            // push 뒤에 입력된 정수값을 queue에 넣음
                last = Integer.parseInt(pushInt[1]);                // 가장 마지막에 push된 값을 last에 저장
            }
            else if (inputArr[i].equals("pop")) {                   // pop 입력인 경우 poll() 함수 사용 / stack 비어있으면 -1 출력
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.poll());
            }
            else if (inputArr[i].equals("size")) {                  // size 입력인 경우 size() 함수 사용
                System.out.println(queue.size());
            }
            else if (inputArr[i].equals("empty")) {                 // empty 입력인 경우 isEmpty() 함수 사용 / stack 비어있으면 1 출력 아니면 0 출력
                if (queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if (inputArr[i].equals("front")) {                 // front 입력인 경우 peek() 사용 / stack 비어있으면 -1 출력
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.peek());
            }
            else if (inputArr[i].equals("back")) {                  // back 입력인 경우 저장된 last 값 출력 / stack 비어있으면 -1 출력
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(last);
            }
        }
    }
}