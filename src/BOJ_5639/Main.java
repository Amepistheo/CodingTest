// 5639번 이진 검색 트리
package BOJ_5639;

import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String input = br.readLine();

            if (input == null || input.isEmpty()) {
                break;
            }

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

        System.out.print(sb);
    }

    // 후위 순위
    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        sb.append(node.value).append("\n");
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    void insert(int n) {
        if (n < this.value) {
            if (this.left == null) {
                this.left = new Node(n);
            }
            else {
                this.left.insert(n);
            }
        }
        else {
            if (this.right == null) {
                this.right = new Node(n);
            }
            else {
                this.right.insert(n);
            }
        }
    }
}