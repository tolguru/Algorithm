import java.util.Arrays;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];

        // 난쟁이들의 키 총합
        int totalHeight = 0;
        int exceededHeight = 0;
        
        // 키 합하기
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(reader.readLine());
            totalHeight += heights[i];
        }
        
        exceededHeight = totalHeight - 100;
        
        // 키 총합에서 100을 초과하는 만큼 합이 나오는 2명의 조합 완전탐색
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] + heights[j] == exceededHeight) {
                    heights[i] = 0;
                    heights[j] = 0;
                }
            }
        }
        
        Arrays.sort(heights);
            
        // 그 둘을 제외하고 전부 출력
        for (int i = 2; i < heights.length; i++) {
            System.out.println(heights[i]);
        }
    }
}