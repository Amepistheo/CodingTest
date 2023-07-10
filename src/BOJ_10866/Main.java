// 10866번 덱
package BOJ_10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();                         // 출력값을 StringBuilder에 저장해놓고 나중에 한번에 출력
        Deque<Integer> deque = new LinkedList<>();                      // Deque 생성

        int N = Integer.parseInt(br.readLine());                        // 명령의 수 N
        String[] inputArr;                                              // 한줄씩 입력받은 명령문 저장하는 배열

        while(N-- > 0) {                                                // while문 사용해서 N만큼 반복
            inputArr = br.readLine().split(" ");                  // inputArr에 띄어쓰기를 기준으로 저장함

            switch(inputArr[0]) {                                       // switch문을 통해 명령문에 해당하는 case로 이동
                case "push_front":                                      // 입력이 push_front인 경우 / offerFirst() 사용하여 inputArr[1]의 값 넣음
                    deque.offerFirst(Integer.valueOf(inputArr[1]));
                    break;                                              // 밑의 case문으로 가지 않도록 break 꼭 써줘야 함!!

                case "push_back":                                       // 입력이 push_back인 경우 / offerLast() 사용하여 inputArr[1]의 값 넣음
                    deque.offerLast(Integer.valueOf(inputArr[1]));
                    break;

                case "pop_front":                                       // 입력이 pop_front인 경우 / deque가 비어있으면 -1 출격 아니면 pollFirst() 사용
                    if (deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.pollFirst()).append('\n');      // 한줄씩 출력하기 위해 '\n' append 해줌

                    break;

                case "pop_back":                                        // 입력이 pop_back인 경우 / deque가 비어있으면 -1 출격 아니면 pollLast() 사용
                    if (deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.pollLast()).append('\n');

                    break;

                case "size":                                            // 입력이 size인 경우 / size() 사용
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":                                           // 입력이 empty인 경우 / deque가 비어있는 경우 1 출력 아니면 0 출력
                    if (deque.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');

                    break;

                case "front":                                           // 입력이 front인 경우 / deque가 비어있으면 -1 출격 아니면 peekFirst() 사용
                    if (deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.peekFirst()).append('\n');

                    break;

                case "back":                                            // 입력이 back인 경우 / deque가 비어있으면 -1 출격 아니면 peekLast() 사용
                    if (deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.peekLast()).append('\n');

                    break;
            }
        }

        System.out.print(sb);                                           // 저장되어 있는 sb 출력
    }
}