import java.io.*;

public class Baek_Joon_8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String quiz = br.readLine();
            int answer = 0;
            int o_count = 0;
            for(int j = 0; j < quiz.length(); j++) {
                if(quiz.charAt(j) == 'O') {
                    o_count++;
                }
                else {
                    o_count = 0;
                }
                answer += o_count;
            }
            
            System.out.println(answer);
        }
    }
}
