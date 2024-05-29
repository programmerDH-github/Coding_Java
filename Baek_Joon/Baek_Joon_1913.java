import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int x = N/2;
        int y = N/2;
        int number = 1;
        int odd = 1;
        while(true) {
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};

            if(x <= 0 && y <= 0) break;

            if(number == 1) {
                arr[x][y] = 1;
                number++;
                odd = odd + 2;
            }

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < odd-1; j++) {
                    if(i == 0 && j == 0) {
                        x--;
                        arr[x][y] = number;
                        number++;
                        j++;
                    }
                    x = x + dx[i];
                    y = y + dy[i];
                    arr[x][y] = number;
                    number++;
                }   
            }

            odd = odd + 2;
        }

        int answer_x = 0;
        int answer_y = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j] + " ");
                if(target == arr[i][j]) {
                    answer_x = i+1;
                    answer_y = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(answer_x +" "+ answer_y);
        System.out.println(sb);

    }
}
