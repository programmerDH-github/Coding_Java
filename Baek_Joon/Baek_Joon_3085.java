import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3085 {
    static int N;
    static String[][] candy_bord;
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,-1,1};
    static boolean[][] visited;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        candy_bord = new String[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String[] color = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                candy_bord[i][j] = color[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1; j++) {
                swap(i, j, i, j+1);
                search();
                swap(i, j+1, i, j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1; j++) {
                swap(j, i, j+1, i);
                search();
                swap(j+1, i, j, i);
            }
        }

        System.out.println(max);

    }

    static void swap(int x1, int y1, int x2, int y2) {
        String temp = candy_bord[x1][y1];
        candy_bord[x1][y1] = candy_bord[x2][y2];
        candy_bord[x2][y2] = temp;
    }

    static void search() {
        
        for(int i = 0; i < N; i++) {
            int count = 1;

            for(int j = 0; j < N-1; j++) {
                if(candy_bord[i][j].equals(candy_bord[i][j+1])) {
                    count++;
                    max = Math.max(count, max);
                }
                else {
                    count = 1;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            int count = 1;

            for(int j = 0; j < N-1; j++) {
                if(candy_bord[j][i].equals(candy_bord[j+1][i])) {
                    count++;
                    max = Math.max(count, max);
                }
                else {
                    count = 1;
                }
            }
        }


    }
}
