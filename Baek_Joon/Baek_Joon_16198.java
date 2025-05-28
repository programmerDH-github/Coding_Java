import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16198 {
    static boolean[] visited;
    static int[] energy;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        energy = new int[N];
        visited = new boolean[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(input[i]);
        }

        // for(int i = 1; i < energy.length-1; i++) {
        //     visited[i] = true;
        //     findEenergySum(0, 0);
        //     visited[i] = false;
        // }

        findEenergySum(0, 0);
        
        System.out.println(answer);

    }

    static void findEenergySum(int count, int sum) {
        if(count == energy.length-2) {
            if(sum > answer) {
                answer = sum;
            }

            return;
        }

        for(int i = 1; i < energy.length-1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                
                int left = i-1;
                int right = i+1;
                while(true) {
                    if(!visited[left] && !visited[right]) break;
                    if(visited[left]) left--;
                    if(visited[right]) right++;
                }

                findEenergySum(count+1, sum+(energy[left]*energy[right]));
                visited[i] = false;
            }
        }

    }

}
