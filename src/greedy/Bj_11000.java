package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Bj_11000 {
    public static void main(String[] args) throws Exception {
        int lectureCount = readInt();
        Lecture[] lecturePlans = new Lecture[lectureCount];

        for (int i = 0; i < lectureCount; i++) {
            lecturePlans[i] = new Lecture(readInt(), readInt());
        }

        /*
        시작 시간 기준으로 정렬
        조건이 ST < ET여서 끝나는 시간이 항상 시작 시간보다 크기 때문에 끝나는 시간은 정렬하지 않아도 된다.
         */
        Arrays.sort(lecturePlans, new CustomComparator());

        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();

        endTimeQueue.offer(0);

        for (int i = 0; i < lectureCount; i++) {
            Lecture lecturePlan = lecturePlans[i];

            // 가장 빠른 종료 시간과 비교해서 종료된 강의 시간을 큐에서 제거
            if (lecturePlan.startTime >= endTimeQueue.peek()) {
                endTimeQueue.poll();
            }

            endTimeQueue.offer(lecturePlan.endTime);
        }

        // 종료 시간 큐의 사이즈로 최대 중첩 강의 수 체크. 기계적이고 급진적인 사고 방식.
        System.out.println(endTimeQueue.size());
    }

    private static int readInt() throws Exception {
        int c;
        int n = System.in.read() & 15; // ASCII 값에서 하위 4비트만 남겨 정수로 추출

        while ((c = System.in.read()) >= 48) { // 다음 바이트도 숫자라면
            n = (n * 10) + (c & 15); // 기존의 n에 10을 곱해줘 자릿수를 올리고 일의 자리에 숫자 추가
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