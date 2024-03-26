import java.io.*;

public class Baek_Joon_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N-1];
        String[] dis = br.readLine().split(" ");
        for(int i = 0; i < distance.length; i++) {
            distance[i] = Long.parseLong(dis[i]);
        }

        long[] cost = new long[N];
        String[] co = br.readLine().split(" ");
        for(int i = 0; i < cost.length; i++) {
            cost[i] = Long.parseLong(co[i]);
        }

        long cur = cost[0];
        long answer = 0;
        for(int i = 0; i < distance.length; i++) {
            if(cur > cost[i+1]) {
                answer += distance[i]*cur;
                cur = cost[i+1];
                continue;
            }           
            
            answer += distance[i]*cur;
        }

        System.out.println(answer);

    }
}
