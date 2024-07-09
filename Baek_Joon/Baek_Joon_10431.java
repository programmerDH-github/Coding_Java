import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10431 {
    static int[] student;
    static int move = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        int[] T = new int[P];
        for(int i = 0; i < P; i++) {
            String[] height = br.readLine().split(" ");
            
            student = new int[height.length-1];
            for(int j = 1; j < height.length; j++) {
                student[j-1] = Integer.parseInt(height[j]);
            }

            int idx = 0;
            move = 0;
            while(idx < student.length-1) {
                if(student[idx] >= student[idx+1]) {
                    swap(idx);
                    idx = 0;
                    continue;
                }
                idx++;
            }

            sb.append(height[0]).append(" ").append(move).append("\n");

        }

        System.out.println(sb);

    }
    static void swap(int idx) {
        int temp = student[idx];
        student[idx] = student[idx+1];
        student[idx+1] = temp;
        move++;
    }
}
