import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ball = br.readLine().split("");

        int answer = Integer.MAX_VALUE;

        boolean check = false;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(check && ball[i].equals("R")) {
                count++;
                continue;
            }

            if(ball[i].equals("B")) check = true;
        }
        if(answer > count) answer = count;

        check = false;
        count = 0;
        for(int i = N-1; i >= 0; i--) {
            if(check && ball[i].equals("R")) {
                count++;
                continue;
            }

            if(ball[i].equals("B")) check = true;
        }
        if(answer > count) answer = count;

        check = false;
        count = 0;
        for(int i = N-1; i >= 0; i--) {
            if(check && ball[i].equals("B")) {
                count++;
                continue;
            }

            if(ball[i].equals("R")) check = true;
        }
        if(answer > count) answer = count;

        check = false;
        count = 0;
        for(int i = N-1; i >= 0; i--) {
            if(check && ball[i].equals("B")) {
                count++;
                continue;
            }

            if(ball[i].equals("R")) check = true;
        }
        if(answer > count) answer = count;

        System.out.println(answer);

    }
}
