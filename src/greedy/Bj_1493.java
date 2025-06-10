package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_1493 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> separatedBoxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 19; i >= 0; i++) {

        }

        int power = 19;

        while (power >= 0) {
            int sideSize = (int) Math.pow(2, power);

            if (sideSize <= length && sideSize <= width && sideSize <= height) {
                separatedBoxQueue.offer(power);
            }
        }

        int[] cubes = new int[20];
        int cubeTypeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < cubeTypeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int cubeType = Integer.parseInt(st.nextToken());
            int cubeCount = Integer.parseInt(st.nextToken());
            cubes[cubeType] = cubeCount;
        }


    }
}