// 1966번 프린터 큐
package BOJ_1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());                         // 테스트 케이스의 수
        String[] inputArr;                                                  // 문서의 개수 N & 몇 번째에 놓여있는지 나타내는 정수 M
        String[] inputQueue;                                                // N개 문서의 중요도

        for (int i = 0; i < test; i++) {
            LinkedList<Node> l = new LinkedList<>();                        // 새로운 LinkedList 생성

            inputArr = br.readLine().split(" ");
            inputQueue = br.readLine().split(" ");

            for (int j = 0; j < Integer.parseInt(inputArr[0]); j++)         // l에 중요도와 위치 저장
                l.offer(new Node(Integer.parseInt(inputQueue[j]), j));

            int count = 0;                                                  //

            while (!l.isEmpty()) {
                Node node = l.pop();                                        // node의 첫번째 값 pop함

                boolean isHigh = true;                                      // 중요도가 가장 높은 것 확인

                for (int k = 0; k < l.size(); k++) {
                    if (node.value < l.get(k).value) {                      // 현재 node보다 l 안에 중요도가 더 높은 문서가 있는 경우 false로 변경
                        isHigh = false;
                        break;
                    }
                }

                if (isHigh) {                                               // 중요도가 가장 높은 것 찾은 경우
                    count++;

                    if (Integer.parseInt(inputArr[1]) == node.index){       // node의 index값과 M의 값이 같은 경우 sb에 더해주고 break
                        sb.append(count).append('\n');
                        break;
                    }
                }
                else                                                        // 현재 l에 중요도가 가장 높은 값이 없는 경우 l에 다시 넣어줌
                    l.offer(node);
            }
        }

        System.out.print(sb);
    }
}

class Node {
    int value, index;

    public Node(int value, int index) {
            this.value = value;
            this.index = index;
    }
}