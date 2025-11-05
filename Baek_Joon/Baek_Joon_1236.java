import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1236 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        String[][] castle = new String[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                castle[i][j] = input[j];
            }
        }

        int row = 0;
        for(int i = 0; i < N; i++) {
            boolean checked = false;
            for(int j = 0; j < M; j++) {
                if(castle[i][j].equals("X")) {
                    checked = true;
                    break;
                }
            }
            
            if(!checked) row++;

        }
        
        int column = 0; 
        for(int i = 0; i < M; i++) {
            boolean checked = false;
            for(int j = 0; j < N; j++) {
                if(castle[j][i].equals("X")) {
                    checked = true;
                    break;
                }
            }

            if(!checked) column++;

        }
        
        System.out.println(row < column ? column : row);

    }
}
