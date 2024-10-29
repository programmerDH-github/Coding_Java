import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1459 {
    static long X,Y,W,S;
    static int[] dx = {1,1,0,1};
    static int[] dy = {1,-1,1,0};
    static long answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] X_Y_W_S = br.readLine().split(" ");
        X = Integer.parseInt(X_Y_W_S[0]);
        Y = Integer.parseInt(X_Y_W_S[1]);
        W = Integer.parseInt(X_Y_W_S[2]);
        S = Integer.parseInt(X_Y_W_S[3]);
        
        if(W*2 <= S) {
            answer = (X+Y) * W;
        }
        else {
            if(W > S) {
                if((X+Y) % 2 == 0) {
                    if(X > Y) {
                        answer = X * S;
                    }
                    else {
                        answer = Y * S;
                    }

                }
                else {
                    if(X > Y) {
                        answer = (X-1) * S + W;
                    }
                    else {
                        answer = (Y-1) * S + W;
                    }
                }
            }
            else {
                if(X > Y) {
                    answer = Y * S + (X-Y) * W;
                }
                else if(X < Y) {
                    answer = X * S + (Y-X) * W;
                }
                else {
                    answer = X * S;
                }
            }
        }

        System.out.println(answer);

    }

}
