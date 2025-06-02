package greedy;

import java.util.Arrays;

public class Bj_11000 {
    public static void main(String[] args) throws Exception {
        int lectureCount = readInt();
        int[][] lecturePlans = new int[lectureCount][2];

        for (int i = 0; i < lectureCount; i++) {
            lecturePlans[i][0] = readInt();
            lecturePlans[i][1] = readInt();
        }

        Arrays.sort(lecturePlans, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int maximumLectureCount = 0;
        int activatedLectureCount = 0;
        int lastLectureEndTime = 0;

        for (int i = 0; i < lectureCount; i++) {
            if (lastLectureEndTime < lecturePlans[i][0]) {
                if (lastLectureEndTime > lecturePlans[i][0]) {
                    activatedLectureCount++;
                }

                lastLectureEndTime = lecturePlans[i][1];
            }

//            if (lastLectureEndTime <= lecturePlans[i][0]) {
//                lastLectureEndTime = lecturePlans[i][1];
//                activatedLectureCount++;
//            }

            maximumLectureCount = Math.max(maximumLectureCount, activatedLectureCount);
        }

        System.out.println(maximumLectureCount);
    }

    private static int readInt() throws Exception {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) >= 48) {
            n = (n * 10) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}