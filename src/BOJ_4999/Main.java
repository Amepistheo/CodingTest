// 4999번 아!
package BOJ_4999;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String jh = br.readLine();
        String doctor = br.readLine();

        if (jh.length() >= doctor.length()) {
            System.out.println("go");
        }
        else {
            System.out.println("no");
        }
    }
}