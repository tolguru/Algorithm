package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_1931 {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int meetingCount = Integer.parseInt(bf.readLine());
        int[][] meetingPlans = new int[meetingCount][2];

        for (int i = 0; i < meetingCount; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            meetingPlans[i][0] = Integer.parseInt(st.nextToken());
            meetingPlans[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetingPlans, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int maximumMeetingCount = 0;
        int lastMeetingEndTime = 0;

        for (int i = 0; i < meetingCount; i++) {
            if (lastMeetingEndTime <= meetingPlans[i][0]) {
                lastMeetingEndTime = meetingPlans[i][1];
                maximumMeetingCount++;
            }
        }

        for (int i = 0; i < meetingCount; i++) {
            System.out.println(meetingPlans[i][0] + " " + meetingPlans[i][1]);
        }

        System.out.println(maximumMeetingCount);
    }
}