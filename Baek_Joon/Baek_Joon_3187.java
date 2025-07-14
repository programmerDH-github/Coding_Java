import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_3187 {
    static int R,C;
    static int survivingWolf = 0, survivingSheep = 0;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] R_C = br.readLine().split(" ");
        R = Integer.parseInt(R_C[0]);
        C = Integer.parseInt(R_C[1]);

        map = new String[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j];
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!visited[i][j] && !map[i][j].equals("#")) {
                    bfs(i,j);
                }
            }
        }

        System.out.println(survivingSheep+" "+survivingWolf);

    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Node(x, y));

        int sheep = 0;
        int wolf = 0;
        if(map[x][y].equals("v")) wolf++;
        else if(map[x][y].equals("k")) sheep++;

        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < R && ny >= 0 && ny < C && !map[nx][ny].equals("#") && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(map[nx][ny].equals("v")) wolf++;
                    else if(map[nx][ny].equals("k")) sheep++;

                    queue.offer(new Node(nx, ny));
                }

            }
        }

        if(wolf >= sheep) survivingWolf += wolf;
        else survivingSheep += sheep;



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
