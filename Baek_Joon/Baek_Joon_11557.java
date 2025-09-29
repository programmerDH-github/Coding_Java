import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int max = 0;
            String name = "";

            for(int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                String university = input[0];
                int drink = Integer.parseInt(input[1]);

                if(max < drink) {
                    max = drink;
                    name = university;
                }

            }
            
            sb.append(name).append("\n");
            
        }        

        System.out.println(sb);

    }
}
