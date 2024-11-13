import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1976 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < N; i++) {
            String[] connection = br.readLine().split(" "); 
            for(int j = 0; j < N; j++) {
                int to = i+1;
                int from = j+1;
                int status = Integer.parseInt(connection[j]);
                if(status == 1) union(to, from);
            }
        }

        String[] city = br.readLine().split(" ");
        for(int i = 0; i < city.length-1; i++) {
            int curCity = Integer.parseInt(city[i]);
            int nextCity = Integer.parseInt(city[i+1]);

            if(parent[curCity] != parent[nextCity]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }

    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

}
