// 14247번 나무 자르기
package BOJ_14247;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Tree> q = new PriorityQueue<>((o1, o2) -> {return o1.growth - o2.growth;});

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            q.offer(new Tree(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        long max = 0;

        for (int i = 0; i < n; i++) {
            Tree tree = q.poll();
            max += (tree.length + tree.growth * i);
        }

        System.out.println(max);
    }
}

class Tree {
    int length;
    int growth;

    public Tree (int length, int growth) {
        this.length = length;
        this.growth = growth;
    }
}