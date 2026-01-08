/*
1
-1000
= -1000

5
-1000 1000 500 -1000 -1000
= 1500

10
10 -4 3 1 5 6 -35 12 21 -1
= 33

10
2 1 -4 3 4 -4 6 5 -5 1
= 14

5
-1 -2 -3 -4 -5
= -1
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        short[] q = new short[n];
        
        for (int i = 0; i < n; i++) {
            q[i] = Short.parseShort(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int currentNum : q) {
            sum = Math.max(currentNum, sum + currentNum);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}