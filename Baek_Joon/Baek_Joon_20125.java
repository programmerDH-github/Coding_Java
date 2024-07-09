import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_20125 {
    static int N;
    static String[][] cookie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        cookie = new String[N][N];
        for(int i = 0; i < N; i++) {
            String block = br.readLine();
            
            cookie[i] = block.split("");
        }

        int heart_x = 0;
        int heart_y = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if("*".equals(cookie[i][j])) {
                    heart_x = i+1;
                    heart_y = j;
                    break;
                }
            }
            if(heart_x != 0 && heart_y != 0) break;            
        }
        System.out.println("heart_x : "+heart_x+", heart_y : "+heart_y);

        sb.append(heart_x+1).append(" ").append(heart_y+1).append("\n");

        //왼팔
        int length = 0;
        for(int j = heart_y-1; j >= 0; j--) {
            if("*".equals(cookie[heart_x][j])) length++;
            else break;
            
        }
        sb.append(length).append(" ");

        //오른팔
        length = 0;
        for(int j = heart_y+1; j < N; j++) {
            if("*".equals(cookie[heart_x][j])) length++;
            else break;
            
        }
        sb.append(length).append(" ");

        
        //허리
        length = 0;
        for(int i = heart_x+1; i < N; i++) {
            if("*".equals(cookie[i][heart_y])) length++;
            else {                
                break;
            }
            
        }
        sb.append(length).append(" ");


        int left_x = heart_x+length+1;
        int left_y = heart_y-1;
        int right_x = heart_x+length+1;
        int right_y = heart_y+1;

        //왼쪽다리
        length = 0;
        for(int i = left_x; i < N; i++) {
            if("*".equals(cookie[i][left_y])) length++;
            else break;
        }
        sb.append(length).append(" ");

        //오른쪽다리
        length = 0;
        for(int i = right_x; i < N; i++) {
            if("*".equals(cookie[i][right_y])) length++;
            else break;
        }
        sb.append(length);        
        
        System.out.println(sb);

    }
}
