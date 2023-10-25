// 1991번 트리 순회
package BOJ_1991;

import java.io.*;
import java.util.*;

public class Main {

    static Node head = new Node('A', null, null);

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        sb.append('\n');
        inOrder(head);
        sb.append('\n');
        postOrder(head);

        System.out.print(sb);
    }

    static void insertNode(Node temp, char root, char left, char right) {
        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        }
        else {
            if (temp.left != null)
                insertNode(temp.left, root, left, right);
            if (temp.right != null)
                insertNode(temp.right, root, left, right);
        }
    }

    // 전위 순회
    static void preOrder(Node node) {
        if (node == null)
            return;

        sb.append(node.value);

        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회
    static void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    // 후위 순회
    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        sb.append(node.value);
    }
}

class Node {
    char value;
    Node left;
    Node right;

    Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}