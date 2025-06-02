package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int holeCount = Integer.parseInt(st.nextToken());
        int tapeSize = Integer.parseInt(st.nextToken());
        int[] holeLocations = new int[holeCount];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < holeCount; i++) {
            holeLocations[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(holeLocations);

        int usedTapeCount = 1;
        int beforeLocation = holeLocations[0];

        for (int i = 0; i < holeCount; i++) {
            if (tapeSize <= holeLocations[i] - beforeLocation) {
                usedTapeCount++;
                beforeLocation = holeLocations[i];
            }
        }

        System.out.println(usedTapeCount);
    }
}