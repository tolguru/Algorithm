package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj_13904 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Project> queue = new PriorityQueue<>(new PointDescComparator());

        /*
        점수 기준으로 내림차순 정렬
        day는 편의상 N-1 처리
         */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Project project = new Project(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));

            queue.offer(project);
        }

        boolean[] schedule = new boolean[1000];
        int resultPoint = 0;

        while (!queue.isEmpty()) {
            Project project = queue.poll();

            // 점수가 가장 높은 과제부터 가장 늦게 할 수 있는 날짜에 스케줄을 등록한다.
            for (int i = project.day; i >= 0; i--) {
                if (!schedule[i]) {
                    schedule[i] = true;
                    resultPoint += project.point;
                    break;
                }
            }
        }

        System.out.println(resultPoint);
    }

    static class Project {
        public int day;
        public int point;

        public Project(int day, int point) {
            this.day = day;
            this.point = point;
        }
    }

    static class PointDescComparator implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return Integer.compare(o2.point, o1.point);
        }
    }
}