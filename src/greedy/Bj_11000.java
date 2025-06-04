package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Bj_11000 {
    public static void main(String[] args) throws Exception {
        int lectureCount = readInt();
        PriorityQueue<Lecture> lecturePlanQueue = new PriorityQueue<>(new CustomComparator());

        for (int i = 0; i < lectureCount; i++) {
            lecturePlanQueue.offer(new Lecture(readInt(), readInt()));
        }

        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();

        endTimeQueue.offer(0);

        while (!lecturePlanQueue.isEmpty()) {
            Lecture lecture = lecturePlanQueue.poll();

            if (lecture.startTime >= endTimeQueue.peek()) {
                endTimeQueue.poll();
            }

            endTimeQueue.offer(lecture.endTime);
        }

        System.out.println(endTimeQueue.size());
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

    static class Lecture {
        public int startTime;
        public int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class CustomComparator implements Comparator<Lecture> {

        @Override
        public int compare(Lecture o1, Lecture o2) {
            return Integer.compare(o1.startTime, o2.startTime);
        }
    }
}