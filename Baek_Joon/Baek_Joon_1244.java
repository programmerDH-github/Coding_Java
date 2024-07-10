import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] switch_status = new int[N+1];
        String[] status = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            switch_status[i] = Integer.parseInt(status[i-1]);
        }

        int student = Integer.parseInt(br.readLine());
        for(int i = 0; i < student; i++) {
            String[] gender_number = br.readLine().split(" ");
            int gender = Integer.parseInt(gender_number[0]);
            int number = Integer.parseInt(gender_number[1]);

            if(gender == 1) {
                for(int j = number; j < switch_status.length; j += number) {
                    switch_status[j] = (switch_status[j]+1) % 2;
                }
            }
            else {
                switch_status[number] = (switch_status[number]+1) % 2;
                for(int j = number+1, k = number-1; j < switch_status.length && k > 0; j++, k--) {
                    if(switch_status[j] == switch_status[k]) {
                        switch_status[j] = (switch_status[j]+1) % 2;
                        switch_status[k] = (switch_status[k]+1) % 2;
                    }
                    else break;
                }
            }

            
        }

        int count = 0;
        for(int i = 1; i < switch_status.length; i++) {
            System.out.print(switch_status[i]+" ");
            count++;

            if(count % 20 == 0) System.out.println();
        }

    }
}
