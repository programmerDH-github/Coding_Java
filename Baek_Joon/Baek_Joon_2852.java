import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] team = new int[2];
        int endTime = 48 * 60;
        int firstTeamScore = 0;
        int secondTeamScore = 0;
        while(N > 0) {
            String[] input = br.readLine().split(" ");            
            int numbers = Integer.parseInt(input[0]);
            String[] times = input[1].split(":");
            int second = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            if(numbers == 1) {
                if(firstTeamScore == secondTeamScore) {
                    team[0] += endTime - second;
                }
                else if(firstTeamScore+1 == secondTeamScore) {
                    team[1] -= endTime - second;
                }

                firstTeamScore++;
            }
            else {
                if(firstTeamScore == secondTeamScore) {
                    team[1] += endTime - second;
                }
                else if(firstTeamScore == secondTeamScore+1) {
                    team[0] -= endTime - second;
                }
                secondTeamScore++;
            }

            N--;
        }

        for(int i = 0; i < 2; i++) {
            String time = "";

            if(team[i]/60 < 10) time += "0" + team[i]/60;
            else time += team[i]/60;

            time += ":";
            
            if(team[i]%60 < 10) time += "0" + team[i]%60;
            else time += team[i]%60;

            sb.append(time).append("\n");
        }

        System.out.println(sb);

    }
}
