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
        int tapeSize = Integer.parseInt(st.nextToken()) - 1;
        int[] holeLocations = new int[holeCount];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < holeCount; i++) {
            holeLocations[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(holeLocations);

        int lastSumIndex = 1;
        int holeConnectionDistanceSum = 0;
        int beforeLocation = 0;
        int usedTapeCount = 0;

        for (int i = 0; i < holeCount; i++) {
            int holeConnectionDistance = holeLocations[i] - beforeLocation;

            if (holeConnectionDistance + holeConnectionDistanceSum <= tapeSize) {
                holeConnectionDistanceSum += holeConnectionDistance;
                beforeLocation = holeLocations[i];
            } else {
                lastSumIndex = i;
                holeConnectionDistanceSum = 0;
                beforeLocation = 0;
                usedTapeCount++;
            }
        }

        if (holeConnectionDistanceSum != 0 || lastSumIndex == holeCount - 1) {
            usedTapeCount++;
        }

        System.out.println(usedTapeCount);
    }
}