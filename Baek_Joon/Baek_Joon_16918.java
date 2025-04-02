import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16918 {
    static int R,C,N;
    static String[][] map,reverseMap;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] R_C_N = br.readLine().split(" ");
        R = Integer.parseInt(R_C_N[0]);
        C = Integer.parseInt(R_C_N[1]);
        N = Integer.parseInt(R_C_N[2]);

        map = new String[R][C];
        reverseMap = new String[R][C];
        for(int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j];
                if(input[j].equals(".")) reverseMap[i][j] = "O";
                else reverseMap[i][j] = ".";
            }
        }
        
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(reverseMap[i][j].equals(".") && !visited[i][j]) {
                    bomb(i, j);
                }
            }
        }
        
        if(N == 1) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        else if(N % 4 == 1) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(reverseMap[i][j].equals(".")) reverseMap[i][j] = "O";
                    else reverseMap[i][j] = ".";
                }
            }

            visited = new boolean[R][C];
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(reverseMap[i][j].equals("O") && !visited[i][j]) {
                        reverseBomb(i, j);
                    }
                }
            }

            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    sb.append(reverseMap[i][j]);
                }
                sb.append("\n");
            }

        }
        else if(N % 4 == 3) {
            

            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    sb.append(reverseMap[i][j]);
                }
                sb.append("\n");
            }
        }
        else {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    sb.append("O");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb);

    }

    static void bomb(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < R && nx >= 0 && ny < C && ny >= 0 && reverseMap[nx][ny].equals("O") && !visited[nx][ny]) {
                visited[nx][ny] = true;
                reverseMap[nx][ny] = ".";
            }

        }

    }

    static void reverseBomb(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < R && nx >= 0 && ny < C && ny >= 0 && reverseMap[nx][ny].equals(".") && !visited[nx][ny]) {
                visited[x][y] = true;
                reverseMap[x][y] = ".";
                break;
            }

        }
    }

}
