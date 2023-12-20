import java.io.*;

public class Baek_Joon_4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for(int i = 0; i < C; i++) {
            String[] N_score = br.readLine().split(" ");
            double N = Double.parseDouble(N_score[0]);
            double sum = 0;
            for(int j = 1; j < N_score.length; j++) {
                sum += Integer.parseInt(N_score[j]);
            }
            double avg = sum/N;

            double count = 0;
            for(int j = 1; j < N_score.length; j++) {
                if(Integer.parseInt(N_score[j]) > avg) count++;
            }

            System.out.println(String.format("%.3f", count/N*100)+"%");
        }
    }
}
