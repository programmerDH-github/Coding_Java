import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);

        parent = new int[n+1];
        for(int i = 1; i < n+1; i++) parent[i] = i;

        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int check = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if(check == 0) {
                union(a, b);
            }
            else {
                if(find(a) == find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }

        }

        System.out.println(sb);
        
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x <= y) parent[y] = x;
            else parent[x] = y;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}
