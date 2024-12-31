import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_14891 {
    static int[][] wheel;
    static int[] start;
    static int[] turn_check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        wheel = new int[4][8];
        start = new int[4]; 
        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(input[j]);        
            }
        }

        
        int K = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int gear_number = Integer.parseInt(input[0])-1;
            int direct = Integer.parseInt(input[1]);

            turn_check = new int[4];

            turn_check[gear_number] = direct;
            turn_check(gear_number);
            turn();
            
        }

        int answer = 0;
        if(wheel[0][0] == 1) answer += 1;
        if(wheel[1][0] == 1) answer += 2;
        if(wheel[2][0] == 1) answer += 4;
        if(wheel[3][0] == 1) answer += 8;

        System.out.println(answer);

    }

    static void turn_check(int number) {
        for(int i = number-1; i >= 0; i--) {
            if(wheel[i][2] != wheel[i+1][6]) {
                turn_check[i] = -turn_check[i+1];
            }
            else break;
        }

        for(int i = number+1; i < 4; i++) {
            if(wheel[i][6] != wheel[i-1][2]) {
                turn_check[i] = -turn_check[i-1];
            } 
            else break;
        }      

    }

    static void turn() {
        int temp = 0;

        for(int i = 0; i < 4; i++) {
            if(turn_check[i] == 1) {
                temp = wheel[i][7];
                for(int j = 7; j > 0; j--) {
                    wheel[i][j] = wheel[i][j-1];
                }
                wheel[i][0] = temp;
            }

            if(turn_check[i] == -1) {
                temp = wheel[i][0];
                for(int j = 0; j < 7; j++) {
                    wheel[i][j] = wheel[i][j+1];
                }
                wheel[i][7] = temp;
            }

        }
    }

}
