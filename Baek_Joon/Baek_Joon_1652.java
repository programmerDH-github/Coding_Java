import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[][] room = new String[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                room[i][j] = input[j];
            }
        }

        // 가로
        int width = 0;
        for(int i = 0; i < N; i++) {
            
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(room[i][j].equals(".")) {
                    count++;
                    if(j == N-1 && count >= 2) width++;
                }
                else {
                    if(count >= 2) width++;
                    count = 0;
                }
            }
                        
        }

        // 세로
        int length = 0;
        for(int i = 0; i < N; i++) {
            
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(room[j][i].equals(".")) {
                    count++;
                    if(j == N-1 && count >= 2) length++;
                }
                else {
                    if(count >= 2) length++;
                    count = 0;
                }
            }
                        
        }

        System.out.println(width+" "+length);

    }
}
