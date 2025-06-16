// 42587번 프로세스
package PG_42587;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> orderQ = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        Queue<Node> q = new LinkedList<>();

        int index = 0;

        for (int p : priorities) {
            orderQ.offer(p);
            q.offer(new Node(index, p));
            index++;
        }

        int count = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.priority == orderQ.peek()) {
                orderQ.poll();
                count++;

                if (node.idx == location) {
                    return count;
                }
            } else {
                q.offer(node);
            }
        }

        return answer;
    }
}

class Node {
    int idx;
    int priority;

    public Node(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}