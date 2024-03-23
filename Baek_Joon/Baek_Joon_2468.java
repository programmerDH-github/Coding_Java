import java.io.*;

public class Baek_Joon_2468 {
    static int N;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};   

    static int max_height = 0;
    static int min_height = 101;
    static int max_safe_area = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];        
        for(int i = 0; i < N; i++) {
            String[] area = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(area[j]);
                if(max_height < Integer.parseInt(area[j])) max_height = Integer.parseInt(area[j]);
                if(min_height > Integer.parseInt(area[j])) min_height = Integer.parseInt(area[j]);
            }
        }

        for(int z = min_height; z <= max_height; z++) {
            int safe_area = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && maps[i][j] > z) {
                        visited[i][j] = true;
                        safe_area++;
                        dfs(i,j,z);
                    }
                }
            }
            if(max_safe_area < safe_area) max_safe_area = safe_area;
        }

        System.out.println(max_safe_area);
        
    }

    public static void dfs(int x, int y, int water_height) {        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny] > water_height) {
                visited[nx][ny] = true;
                dfs(nx,ny,water_height);
            }
        }
    }
}
