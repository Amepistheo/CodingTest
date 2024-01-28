// 14405번 피카츄
package BOJ_14405;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String regex = "pi|ka|chu";

        S = S.replaceAll(regex, "");

        if (S.equals("")) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}