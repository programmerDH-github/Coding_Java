import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_2615 {
    static int[][] game;
    static boolean[][] visited;
    static int[] dx = {1,1,1,0};
    static int[] dy = {-1,0,1,1};
    static ArrayList<Integer> arraylist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arraylist = new ArrayList<>();

        game = new int[20][20];
        visited = new boolean[19][19];
        for(int i = 1; i <= 19; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= 19; j++) {
                game[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= 19; j++) {
                if(game[i][j] != 0) {
                    for(int k = 0; k < 4; k++) {
                        dfs(i,j,k,1,game[i][j]);
                    }
                }
            }
        }
         
        if(arraylist.isEmpty()) {
            System.out.println(0);
        }
        else {
            System.out.println(arraylist.get(0));
            System.out.println(arraylist.get(1)+" "+arraylist.get(2));
        }

    }

    static void dfs(int x, int y, int direct, int count, int target) {
        if(count == 5) {
            int nx = x + dx[direct];
            int ny = y + dy[direct];

            if(nx > 0 && nx <= 19 && ny > 0 && ny <= 19 && game[nx][ny] == target) {
                return;
            }

            nx = x - (dx[direct]*5);
            ny = y - (dy[direct]*5);

            if(nx > 0 && nx <= 19 && ny > 0 && ny <= 19 && game[nx][ny] == target) {
                return;
            }

            if(direct == 0) {
                arraylist.add(target);
                arraylist.add(x);
                arraylist.add(y);
            }
            else {
                arraylist.add(target);
                arraylist.add(x-(dx[direct]*4));
                arraylist.add(y-(dy[direct]*4));
            }
            return;
        }

        int nx = x + dx[direct];
        int ny = y + dy[direct];

        if(nx > 0 && nx <= 19 && ny > 0 && ny <= 19 && game[nx][ny] == target) {
            dfs(nx, ny, direct, count+1, target);
        }
    }

}
