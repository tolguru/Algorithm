package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sequenceNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            int a = v / p;
            int b = a * p;
            int c = v - b;
            int result = a * l + Math.min(c, l);

            sb.append("Case ").append(sequenceNum++).append(": ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}