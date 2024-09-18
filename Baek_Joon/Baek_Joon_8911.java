import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_8911 {
    // 북동남서
    static int[] dx = {0,1,0,-1}; 
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String input = br.readLine();

            int max_x = 0;
            int min_x = 0;
            int max_y = 0;
            int min_y = 0;
            int dir = 0;
            int x = 0;
            int y = 0;
            for(int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                }
                else if(input.charAt(j) == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                }
                else if(input.charAt(j) == 'L') {
                    dir--;
                }
                else if(input.charAt(j) == 'R') {
                    dir++;
                }

                if(dir < 0) dir += 4;
                if(dir >= 4) dir %= 4;

                if(max_x < x) max_x = Math.abs(x);
                if(max_y < y) max_y = Math.abs(y);

                if(min_x > x) min_x = x;
                if(min_y > y) min_y = y;

                
            }

            sb.append((max_x-min_x) * (max_y-min_y)).append("\n");

        }

        System.out.println(sb);

    }
}
