import java.io.*;

public class Baek_Joon_1018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);
        int answer = 32;

        String[][] chess = new String[N][M];
        for(int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                chess[i][j] = arr[j];
            }
        }
        
        int x = 0;
        int y = 0;        
        boolean check = true;
        while (N-x > 7 && M-y > 7) {
            int change = 0;

            for(int i = x; i < x+8; i++) {
                for(int j = y; j < y+8; j++) {
                    if(i == x && j == y) {
                        if(chess[i][j].equals("W")) check = true;
                        else check = false;

                    }
                    else if(j == y) {              
                        if(chess[i][j].equals("W") && check) {
                            continue;
                        }
                        else if(chess[i][j].equals("B") && !check) {
                            continue;
                        }
                        else {
                            if(chess[i][j].equals("W") && !check) {
                                check = false;
                            }
                            else if(chess[i][j].equals("B") && check) {
                                check = true;
                            }                            
                            change++;
                        }
                    }
                    else {
                        if(check) {
                            if(chess[i][j].equals("W")) {                               
                                change++;
                            }
                            check = false;
                        }
                        else {
                            if(chess[i][j].equals("B")) {
                                change++;
                            }                                
                            check = true;
                        }
                    }
                }
            }
            
            y++;
            if(M-y <= 7) {
                x++;
                y = 0;
            }

            if(change > 64-change) change = 64-change;
            if(answer > change) answer = change;
            if(N-x <= 7){
                break;
            }
        }

        System.out.println(answer);

    }
}
