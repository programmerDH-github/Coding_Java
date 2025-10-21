import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2567 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[100][100];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            for(int j = n; j < n+10; j++) {
                for(int k = m; k < m+10; k++) {
                    arr[j][k] = 1;
                }
            }

        }


        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++){
                if(arr[i][j] == 1) around(i, j);
            }
        }

        System.out.println(answer);

    }

    static void around(int x, int y) {
        if(x == 0 || x == 99) answer++;
        if(y == 0 || y == 99) answer++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 100 && nx >= 0 && ny < 100 && ny >= 0 && arr[nx][ny] == 0) answer++;    
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
